package com.takeout;


import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.shardingjdbc.spring.boot.SpringBootConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j // lombok日志注解
// 排除主从数据库模式，默认用单数据库模式，SpringBootConfiguration.class是主从数据库的配置依赖
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, SpringBootConfiguration.class})
@ServletComponentScan
@EnableTransactionManagement
@EnableCaching
public class TakeOutApplication {
    public static void main(String[] args) {
        SpringApplication.run(TakeOutApplication.class);
        log.info("项目启动...");
    }
}
