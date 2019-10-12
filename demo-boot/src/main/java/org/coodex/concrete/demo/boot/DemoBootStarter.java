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

import org.coodex.concrete.core.intercept.LicenseCheckInterceptor;
import org.coodex.concrete.formatters.FreemarkerLogFormatter;
import org.coodex.concrete.spring.boot.EnableConcreteAMQP;
import org.coodex.concrete.spring.boot.EnableConcreteJAXRS;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(
        scanBasePackages = "org.coodex.concrete.demo.**.impl"
)
// 启用concrete jaxrs
@EnableConcreteJAXRS(
        servicePackages = "org.coodex.concrete.demo.**.api"
)
//// 启用concrete amqp
//@EnableConcreteAMQP(
//        servicePackages = "org.coodex.concrete.demo.**.api"
//)
public class DemoBootStarter {

    private static String[] PACKAGES = new String[]{
            "org.coodex.concrete.demo.**.api"
    };

    public static void main(String[] args) {
        SpringApplication.run(DemoBootStarter.class, args);
    }

//    @Bean
//    public AMQPApplication getAMQPApplication() {
//        AMQPConnectionConfig config = new AMQPConnectionConfig();
//        Profile profile = Profile.get("amqp.service");
//        config.setUri(profile.getString("location"));
//        config.setUsername(profile.getString("amqp.username"));
//        config.setPassword(profile.getString("amqp.password"));
//        AMQPApplication amqpApplication = new AMQPApplication(
//                config,
//                profile.getString("amqp.exchangeName"),
//                profile.getString("amqp.queueName"),
//                profile.getLong("amqp.ttl")
//        );
//        amqpApplication.registerPackage(PACKAGES);
//        return amqpApplication;
//    }

    @Bean
    public LicenseCheckInterceptor licenseCheckInterceptor(){
        return new LicenseCheckInterceptor();
    }


    // 使用 freemarker 的 formatter
    @Bean
    public FreemarkerLogFormatter freemarkerLogFormatter() {
        return new FreemarkerLogFormatter();
    }


}
