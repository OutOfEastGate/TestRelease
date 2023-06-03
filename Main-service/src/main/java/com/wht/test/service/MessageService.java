package com.wht.test.service;

import com.wht.client.exception.CustomException;
import com.wht.client.exception.ErrorCode;
import com.wht.client.form.message.AddMailMessageForm;
import com.wht.client.form.message.AddMessageForm;
import com.wht.client.obj.MessageDo;
import com.wht.test.repository.MessageRepository;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * description:
 *
 * @author wht
 * @createDate 2023/4/26 22:16
 */
@Service
public class MessageService {
    @Autowired
    MessageRepository messageRepository;
    @Autowired
    JavaMailSenderImpl javaMailSender;

    public void addMessage(AddMessageForm addMessageForm) {
        MessageDo messageDo = new MessageDo();
        BeanUtils.copyProperties(addMessageForm,messageDo);
        messageRepository.save(messageDo);
    }

    public List<MessageDo> getAllMessages() {
        List<MessageDo> messageDos = messageRepository.findAll();
        Collections.reverse(messageDos);
        return messageDos;
    }

    public void addMailMessage(AddMailMessageForm addMailMessageForm) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(mimeMessage, true);
            //标题
            helper.setSubject(addMailMessageForm.getTitle());
            //内容(html)
            helper.setText(addMailMessageForm.getText(), true);
            //接受者
            helper.setTo(addMailMessageForm.getTargetMail());
            helper.setFrom(javaMailSender.getUsername());
            javaMailSender.send(mimeMessage);
        }catch (Exception e) {
            throw new CustomException(ErrorCode.MAIL_ERROR);
        }
    }
}
