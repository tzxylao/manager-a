package com.tzxylao.manager.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author laoliangliang
 * @date 2018/9/26 17:39
 */
@Controller
@RequestMapping("/json/menu")
public class JSONMenuController {


    @RequestMapping("/summary")
    @ResponseBody
    @RequiresPermissions(value = {"菜单管理"})
    public String tousermanage() {
        String str = "{\n" +
                "    \"msg\": \"\",\n" +
                "    \"code\": 0,\n" +
                "    \"data\": [\n" +
                "        {\"id\":\"1\", \"pId\":\"0\", \"name\":\"水果\"},\n" +
                "        {\"id\":\"101\", \"pId\":\"1\", \"name\":\"苹果\"},\n" +
                "        {\"id\":\"102\", \"pId\":\"1\", \"name\":\"香蕉\"},\n" +
                "        {\"id\":\"103\", \"pId\":\"1\", \"name\":\"梨\"},\n" +
                "        {\"id\":\"10101\", \"pId\":\"101\", \"name\":\"红富士苹果\"},\n" +
                "        {\"id\":\"10102\", \"pId\":\"101\", \"name\":\"红星苹果\"},\n" +
                "        {\"id\":\"10103\", \"pId\":\"101\", \"name\":\"嘎拉\"},\n" +
                "        {\"id\":\"10104\", \"pId\":\"101\", \"name\":\"桑萨\"},\n" +
                "        {\"id\":\"10201\", \"pId\":\"102\", \"name\":\"千层蕉\"},\n" +
                "        {\"id\":\"10202\", \"pId\":\"102\", \"name\":\"仙人蕉\"},\n" +
                "        {\"id\":\"10203\", \"pId\":\"102\", \"name\":\"吕宋蕉\"}\n" +
                "    ],\n" +
                "    \"count\": 924,\n" +
                "    \"is\": true,\n" +
                "    \"tip\": \"操作成功！\"\n" +
                "}";
        return str;
    }
}
