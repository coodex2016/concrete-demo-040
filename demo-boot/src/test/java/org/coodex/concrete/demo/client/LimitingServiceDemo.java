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

package org.coodex.concrete.demo.client;

import org.coodex.concrete.Client;
import org.coodex.concrete.ClientException;
import org.coodex.concrete.demo.api.excepted.LimitingService;
import org.coodex.concurrent.ExecutorsHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;

public class LimitingServiceDemo {
    private final static Logger log = LoggerFactory.getLogger(LimitingServiceDemo.class);


    private static final ExecutorService EXECUTOR_SERVICE =
            ExecutorsHelper.newFixedThreadPool(30, "demo");

    public static void main(String[] args) {
        LimitingService limitingService = Client.getInstance(LimitingService.class, "jaxrs");
        // 连着请求 demoMaximumConcurrency
        for (int i = 1; i <= 20; i++) {
            int finalI = i;
            EXECUTOR_SERVICE.execute(() -> {

                try {
                    limitingService.demoMaximumConcurrency();
                } catch (ClientException e) {
                    log.info("{}, demoMaximumConcurrency {}", finalI, e.getLocalizedMessage());
                }
            });
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignore) {
            }
        }


        EXECUTOR_SERVICE.execute(() -> {
            for (int i = 1; i < 30; i++) {
                try {
                    limitingService.demoTokenBucket();
                } catch (ClientException e) {
                    log.info("{}, demoTokenBucket {}", i, e.getLocalizedMessage());
                }
                if (i % 5 == 0) { // 每5个任务一组，每组之间休息800毫秒
                    try {
                        Thread.sleep(800);
                    } catch (InterruptedException ignore) {
                    }
                }

            }
        });
    }

}
