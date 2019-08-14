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

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import org.coodex.concurrent.ExecutorsHelper;
import org.coodex.concurrent.Parallel;
import org.coodex.util.Clock;
import org.coodex.util.Common;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ParallelDemo {
    private final static Logger log = LoggerFactory.getLogger(ParallelDemo.class);


    public static void main(String[] args) {
        List<Runnable> runnables = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            int finalI = i;
            runnables.add(() -> {
                try {
                    Clock.sleep(Common.random(3000));
                    log.info("task {} finished.", finalI);
                } catch (InterruptedException ignore) {
                }
            });
        }

        Parallel.Batch batch = new Parallel(
                // 5个线程来执行并行任务
                ExecutorsHelper.newFixedThreadPool(5, "parallel")
        ).run(runnables.toArray(new Runnable[0]));
        log.info("all task finished.");
        log.info("\n{}", JSON.toJSONString(batch, true));
    }
}
