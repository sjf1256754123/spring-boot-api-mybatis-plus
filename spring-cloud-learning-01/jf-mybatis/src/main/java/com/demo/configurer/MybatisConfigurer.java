package com.demo.configurer;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import java.util.Properties;

import static com.demo.core.ProjectConstant.MAPPER_PACKAGE;

/**
 * Mybatis & Mapper & PageHelper 配置
 * @author Gahon
 */
@Configuration
public class MybatisConfigurer {

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
//        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
        mapperScannerConfigurer.setBasePackage(MAPPER_PACKAGE);

        //配置通用Mapper，详情请查阅官方文档

        Properties properties = new Properties();
//        properties.setProperty("mappers", MAPPER_INTERFACE_REFERENCE); //4.0之后版本不需要，除非自定义mapper

        //insert、update是否判断字符串类型!='' 即 test="str != null"表达式内是否追加 and str != ''
        properties.setProperty("notEmpty", "false");
        //取回主键的方式
        properties.setProperty("IDENTITY", "MYSQL");
        //配置后会自动处理关键字，可以配的值和数据库有关。
        properties.setProperty("wrapKeyword", "`{0}`");
        mapperScannerConfigurer.setProperties(properties);

        return mapperScannerConfigurer;
    }

}

