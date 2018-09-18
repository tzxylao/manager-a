package com.tzxylao.manager.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author laoliangliang
 * @date 18/9/9 下午1:17
 */
@Controller
@RequestMapping("/test")
@Slf4j
public class TestController {

    @RequestMapping("/ip")
    @ResponseBody
    public String getIp() throws UnknownHostException {
        InetAddress addr = InetAddress.getLocalHost();
        //获取本机ip
        String ip = addr.getHostAddress();
        //获取本机计算机名称
        String hostName = addr.getHostName();
        System.out.println(ip);
        System.out.println(hostName);
        log.info("ip:" + ip);
        return "ip:" + ip + "\n\r hostname:" + hostName;
    }
}
