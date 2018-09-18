package com.tzxylao.manager.jobhandler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by lll on 2018/9/17 14:38.
 */
@Component
@JobHandler("testJobHandler")
@Slf4j
public class TestJobjHandler extends IJobHandler{
    private int i = 0;
    @Override
    public ReturnT<String> execute(String s) throws Exception {
        ReturnT<String> returnT = new ReturnT<>();
        log.info("执行TestJobjHandler "+i);
        i++;
        if (i % 5 == 0) {
            returnT.setMsg("执行失败"+i);
            returnT.setContent("内容xxxx");
            returnT.setCode(500);
            return returnT;
        }
        return ReturnT.SUCCESS;
    }
}
