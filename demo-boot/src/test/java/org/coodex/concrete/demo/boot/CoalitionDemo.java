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

import org.coodex.concurrent.Coalition;
import org.coodex.concurrent.Debouncer;
import org.coodex.concurrent.Throttler;
import org.coodex.util.Common;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CoalitionDemo {
    private final static Logger log = LoggerFactory.getLogger(CoalitionDemo.class);

    private static void test(Coalition<Integer> coalition) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            coalition.call(i);
            // 随机休眠15毫秒以内
            Thread.sleep(Common.random(15));
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 只有空闲15毫秒以后才做一次
        test(new Debouncer<>(
                arg -> log.info("Debouncer saved: {}", arg), 15
        ));

        // 最多500毫秒执行一次
        test(new Throttler<>(
                arg -> log.info("Throttler saved: {}", arg), 500
        ));
    }
}
