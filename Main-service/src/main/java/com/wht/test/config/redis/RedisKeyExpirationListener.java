package com.wht.test.config.redis;

import com.wht.client.dto.IpQueryDto;
import com.wht.client.obj.IpDo;
import com.wht.test.repository.IpRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/5/20 20:06
 */
@Component
@Slf4j
public class RedisKeyExpirationListener extends KeyExpirationEventMessageListener {
    IpRepository ipRepository;

    RestTemplate restTemplate;

    @Autowired
    public void setIpRepository(IpRepository ipRepository) {
        this.ipRepository = ipRepository;
    }
    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public RedisKeyExpirationListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }

    public void onMessage(Message message, byte[] pattern) {
        String key = message.toString();
        if (key.startsWith("IP:")) {//IP过期
            String ip = key.replace("IP:", "");
            IpDo ipDoByIP = ipRepository.findIpDoByIP(ip);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            ResponseEntity<IpQueryDto> responseEntity = restTemplate.getForEntity("http://ip-api.com/json/" + ip, IpQueryDto.class);
            IpQueryDto ipQueryDto = responseEntity.getBody();
            if (ipDoByIP == null) {
                IpDo ipDo = new IpDo();
                ipDo.setDate(dateFormat.format(new Date()));
                ipDo.setIP(ip);
                ipDo.setTimes(1l);
                if (ipQueryDto != null && ipQueryDto.getStatus().equals("success")) {
                    ipDo.setCountry(ipQueryDto.getCountry());
                    ipDo.setCity(ipQueryDto.getCity());
                    ipDo.setTimezone(ipQueryDto.getTimezone());
                }
                ipRepository.save(ipDo);
            } else {
                ipDoByIP.setTimes(ipDoByIP.getTimes() + 1);
                ipDoByIP.setDate(dateFormat.format(new Date()));
                ipRepository.save(ipDoByIP);
            }
        }
    }
}
