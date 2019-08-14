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

import org.coodex.util.Clock;
import org.coodex.util.Common;
import org.coodex.util.clock.ClockAgentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClockDemo {
    private final static Logger log = LoggerFactory.getLogger(ClockDemo.class);

    private static final long AN_HOUR = 60 * 60 * 1000;

    public static void main(String[] args) throws InterruptedException {

        // 启动时间管理中心
        new ClockAgentService().start();

        for (int i = 1; i <= 10; i++) {
            Clock.sleep(AN_HOUR);
            log.info("{}: {}", i, Common.calendarToStr(Clock.getCalendar()));
        }
    }
}
