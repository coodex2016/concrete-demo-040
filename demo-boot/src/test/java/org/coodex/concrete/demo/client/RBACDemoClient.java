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
import org.coodex.concrete.demo.api.excepted.DemoLoginService;
import org.coodex.concrete.demo.api.excepted.LibraryA;
import org.coodex.concrete.demo.api.excepted.LibraryB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RBACDemoClient {
    private final static Logger log = LoggerFactory.getLogger(RBACDemoClient.class);

    private static void demoA() {
        LibraryA library = Client.getInstance(LibraryA.class, "jaxrs");
        library.delete("A1");
        library.sort();
        library.delete("A2");
    }

    private static void demoB() {
        LibraryB library = Client.getInstance(LibraryB.class, "jaxrs");
        library.delete("B1");
        library.sort();
        library.delete("B2");
    }

    public static void main(String[] args) {
        String[] users = new String[]{
                "A", "B", "C", "D"
        };
        for (String s : users) {
            try {
                DemoLoginService demoLoginService = Client.getInstance(DemoLoginService.class, "jaxrs");
                demoLoginService.login(s);
                try {
                    demoA();
                } catch (ClientException e) {
                    log.info("demoA [user: {}] error: {}, {}", s, e.getCode(), e.getMessage());
                }

                try {
                    demoB();
                } catch (ClientException e) {
                    log.info("demoB [user: {}] error: {}, {}", s, e.getCode(), e.getMessage());
                }
            } catch (ClientException e) {
                log.info("login failed: {}", e.getLocalizedMessage());
            }
        }
    }
}
