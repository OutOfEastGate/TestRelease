-- 为某个接口的请求IP设置计数器，比如：127.0.0.1
-- KEYS[1] = 127.0.0.1 也就是用户的IP
-- ARGV[1] = 过期时间 30m
-- ARGV[2] = 限制的次数

-- 允许本地测试
if KEYS[1] == "127.0.0.1" then
    return true
end

-- 判断是否被拉黑(基于布隆过滤器)
local res = redis.call('bf.exists','DENY_IP',KEYS[1])

if res == 1 then
    return false
end


local limitCount = redis.call('incr','IP:'..KEYS[1]);

if limitCount == 1 then
    redis.call("expire",'IP:'..KEYS[1],ARGV[1])
    return true
end
-- 如果次数还没有过期，并且还在规定的次数内，说明还在请求同一接口
if limitCount > tonumber(ARGV[2]) then
-- 拉黑ip
    redis.call('bf.add','DENY_IP',KEYS[1])
    return false
end

return true
