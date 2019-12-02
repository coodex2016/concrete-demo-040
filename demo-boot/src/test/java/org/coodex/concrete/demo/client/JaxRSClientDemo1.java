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
import org.coodex.concrete.demo.api.CompletableSubjoinExampleService;
import org.coodex.concrete.demo.api.ObservableSubjoinExampleService;
import org.coodex.concrete.demo.api.SubjoinExampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.BiConsumer;

public class JaxRSClientDemo1 {
    private final static Logger log = LoggerFactory.getLogger(JaxRSClientDemo1.class);

    public static void main(String[] args) {
        log.info("restful service invoked: {}",
                Client.getInstance(SubjoinExampleService.class, "jaxrs")
                        .add(11, 12)
        );

        Client.getInstance(CompletableSubjoinExampleService.class, "jaxrs")
                .add(11, 12)
                .whenComplete((integer, throwable) -> {
            if (throwable != null) {
                log.error(throwable.getLocalizedMessage(), throwable);
            } else {
                log.info("completable restful service invoked: {}", integer);
            }
        });

        Client.getInstance(ObservableSubjoinExampleService.class, "jaxrs")
                .add(11,12)
                .subscribe(integer -> {
                    log.info("observable restful service invoked: {}", integer);
                });

    }
}
