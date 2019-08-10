/*
 * Copyright (c) 2019 coodex.org (jujus.shen@126.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.coodex.concrete.demo.boot;

import org.coodex.concrete.amqp.AMQPConnectionConfig;
import org.coodex.concrete.core.intercept.LimitingInterceptor;
import org.coodex.concrete.core.intercept.OperationLogInterceptor;
import org.coodex.concrete.core.intercept.RBACInterceptor;
import org.coodex.concrete.core.intercept.ServiceTimingInterceptor;
import org.coodex.concrete.formatters.FreemarkerLogFormatter;
import org.coodex.concrete.spring.ConcreteSpringConfiguration;
import org.coodex.concrete.support.amqp.AMQPApplication;
import org.coodex.concrete.support.jsr339.ConcreteJSR339Application;
import org.coodex.util.Profile;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@SpringBootApplication(
        scanBasePackages = "org.coodex.concrete.demo.**.impl"
)
@Import(ConcreteSpringConfiguration.class) // 在ConcreteSpringConfiguration中定义了BeanProvider基于spring的实现
public class DemoBootStarter {

    private static String[] PACKAGES = new String[]{
            "org.coodex.concrete.demo.**.api"
    };

    public static void main(String[] args) {
        SpringApplication.run(DemoBootStarter.class, args);
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        ServletContainer container = new ServletContainer();
        //noinspection unchecked
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(
                container, "/jaxrs/*");
        // 使用jersey发布jaxrs应用，concrete在javax.rs.Application基础上进行了封装
        registrationBean.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS,
                DemoApplication.class.getName());
        // servlet3.0带来的新特性，异步servlet，极大提高了servlet处理能力，强烈推荐
        registrationBean.setAsyncSupported(true);
        return registrationBean;
    }

    @Bean
    public AMQPApplication getAMQPApplication() {
        AMQPConnectionConfig config = new AMQPConnectionConfig();
        Profile profile = Profile.get("amqp.service");
        config.setUri(profile.getString("location"));
        config.setUsername(profile.getString("amqp.username"));
        config.setPassword(profile.getString("amqp.password"));
        AMQPApplication amqpApplication = new AMQPApplication(
                config,
                profile.getString("amqp.exchangeName"),
                profile.getString("amqp.queueName"),
                profile.getLong("amqp.ttl")
        );
        amqpApplication.registerPackage(PACKAGES);
        return amqpApplication;
    }

    @Bean
    public RBACInterceptor rbacInterceptor() {
        return new RBACInterceptor();
    }

    // 操作日志 拦截器
    @Bean
    public OperationLogInterceptor operationLogInterceptor() {
        return new OperationLogInterceptor();
    }

    // 限流拦截器
    @Bean
    public LimitingInterceptor limitingInterceptor() {
        return new LimitingInterceptor();
    }

    // 服务时间限定拦截器
    @Bean
    public ServiceTimingInterceptor serviceTimingInterceptor(){
        return new ServiceTimingInterceptor();
    }

    // 使用 freemarker 的 formatter
    @Bean
    public FreemarkerLogFormatter freemarkerLogFormatter() {
        return new FreemarkerLogFormatter();
    }

    public static class DemoApplication
            extends ConcreteJSR339Application {
        public DemoApplication() {
            super();
            // 使用jersey的jackson能力，用来进行json的序列化和反序列化
            register(JacksonFeature.class);
            // 注册concrete service。ConcreteApplication提供两种方式，一种直接注册接口类，一种进行包检索，包检索的定义与spring的scan一致
            registerPackage(PACKAGES);
        }
    }

}
