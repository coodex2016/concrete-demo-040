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
import org.coodex.concrete.client.jaxrs.JaxRSDestination;
import org.coodex.concrete.demo.api.SubjoinExampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JaxRSClientDemo2 {
    private final static Logger log = LoggerFactory.getLogger(JaxRSClientDemo2.class);

    public static void main(String[] args) {
        JaxRSDestination destination = new JaxRSDestination();
        destination.setLocation("http://localhost:8080/jaxrs");
        log.info("restful service invoked: {}",
                Client.getInstance(SubjoinExampleService.class, destination).add(11, 12));
    }
}
