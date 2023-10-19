package com.beosin.alert.common.config.mybatisplus;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * mybatis 配置
 *
 * @author shangye
 * @date 2021/11/30
 */
@Configuration
public class PluginMybatisPlusConfig {

    @Bean
    ExpandSqlInjector expandSqlInjector() {
        return new ExpandSqlInjector();
    }

//    @Bean
//    public MybatisPlusInterceptor mybatisPlusInterceptor() {
//        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
//        // 向MyBatis-Plus的过滤器链中添加分页拦截器，需要设置数据库类型（主要用于分页方言）
//        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
//        return interceptor;
//    }
}
