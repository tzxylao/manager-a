package com.tzxylao.manager.hystrix;

import com.netflix.hystrix.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.util.concurrent.TimeUnit;

/**
 * @author laoliangliang
 * @date 2018/10/31 9:20
 */
@Slf4j
public class IpHystrixCommand extends HystrixCommand<String> {

    private HttpServletRequest request;

    private RedisTemplate<String, String> redisTemplate;

    public IpHystrixCommand(HttpServletRequest request, RedisTemplate<String, String> redisTemplate) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("IpCommandGroup")).
                andCommandKey(HystrixCommandKey.Factory.asKey("IpCommand")).
                andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("ipThreadPool")).
                andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(15000).withExecutionTimeoutEnabled(true).withMetricsRollingStatisticalWindowInMilliseconds(15000).withMetricsRollingPercentileWindowInMilliseconds(15000).withFallbackIsolationSemaphoreMaxConcurrentRequests(1000).withExecutionIsolationSemaphoreMaxConcurrentRequests(1000)).
                andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().withCoreSize(100).withMaximumSize(120).withMaxQueueSize(200))
        );
        this.request = request;
        this.redisTemplate = redisTemplate;
    }

    @Override
    protected String run() throws Exception {
        InetAddress addr = InetAddress.getLocalHost();
        //获取本机ip
        String ip = addr.getHostAddress();
        //获取本机计算机名称
        String hostName = addr.getHostName();
        System.out.println(ip);
        System.out.println(hostName);
        log.info("ip:" + ip);
        log.info("ip:" + request.getRemoteAddr());
        log.info("X-Real-IP:{}", request.getHeader("X-Real-IP"));
        InetAddress inetAddress = InetAddress.getByName(request.getRemoteAddr());
        log.info("HostAddress:" + inetAddress.getHostAddress());
        String auth = request.getHeader("Authorization");
        log.info("Authorization:" + auth);
//        Thread.sleep(300);
        String key = "IpHystrixCommand_count";
        Long increment = redisTemplate.opsForValue().increment(key, 1);
        if (increment == 1L) {
            redisTemplate.expire(key,60L, TimeUnit.SECONDS);
        }
        log.error("----------count={}-----------", increment);
        return "ip:" + ip + "\n\r hostname:" + hostName;
    }

    @Override
    protected String getFallback() {
        log.info("服务器繁忙");
        return "服务器繁忙";
    }
}
