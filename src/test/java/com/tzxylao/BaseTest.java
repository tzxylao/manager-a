package com.tzxylao;

import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author laoliangliang
 * @date 2018/9/28 10:05
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.tzxylao.manager.mapper.ext")
public class BaseTest {
}
