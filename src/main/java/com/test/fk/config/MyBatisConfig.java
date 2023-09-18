package com.test.fk.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 * Created by macro on 2019/4/8.
 */
@Configuration
@MapperScan({"com.test.fk.mbg.mapper", "com.test.fk.dao"})
public class MyBatisConfig {
}
