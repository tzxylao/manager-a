package com.tzxylao.manager;

import com.alibaba.fastjson.JSON;
import com.tzxylao.BaseTest;
import com.tzxylao.manager.entity.DpageConfig;
import com.tzxylao.manager.entity.Tmenu;
import com.tzxylao.manager.entity.Tuserrole;
import com.tzxylao.manager.mapper.ext.DpageConfigMapper;
import com.tzxylao.manager.mapper.TmenuMapper;
import com.tzxylao.manager.mapper.TuserroleMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author laoliangliang
 * @date 2018/9/28 10:04
 */
@Slf4j
public class DpageConfigMapperTest extends BaseTest{

    @Autowired
    private DpageConfigMapper dpageConfigMapper;

    @Autowired
    private TmenuMapper tmenuMapper;

    @Autowired
    private TuserroleMapper tuserroleMapper;

    @Test
    public void testAddBatch(){
        List<Tmenu> tmenus = tmenuMapper.selectAll();
        log.info("{}", JSON.toJSONString(tmenus));

        List<DpageConfig> list = new ArrayList<>();
        DpageConfig config = new DpageConfig();
        config.setJsonId(1L);
        config.setText("{\"name\":\"喜洋洋1\"}");
        list.add(config);
        config = new DpageConfig();
        config.setJsonId(2L);
        config.setText("{\"name\":\"喜洋洋2\"}");
        list.add(config);
        int i = dpageConfigMapper.insertList(list);
        if (i > 0) {
            log.info("插入成功{}条", i);
        }else{
            log.info("插入失败{}条", i);
        }
    }

    @Test
    public void getBatch(){
        List<Tmenu> tmenus = tmenuMapper.selectAll();
        log.info("{}", JSON.toJSONString(tmenus));
    }

    @Test
    public void addUserRoleBatch(){
        List<Tuserrole> tuserroles = new ArrayList<>();
        Tuserrole tuserrole = new Tuserrole();
        tuserrole.setUserId(111111);
        tuserrole.setRoleId(222222);
        tuserroles.add(tuserrole);
        tuserrole = new Tuserrole();
        tuserrole.setUserId(111111);
        tuserrole.setRoleId(222222);
        tuserroles.add(tuserrole);
        tuserroleMapper.insertList(tuserroles);
    }
}