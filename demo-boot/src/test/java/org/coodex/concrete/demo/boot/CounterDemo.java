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

import org.coodex.concrete.spring.SpecificMomentSegmentation;
import org.coodex.concurrent.ExecutorsHelper;
import org.coodex.count.*;
import org.coodex.util.Common;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class CounterDemo {
    private final static Logger log = LoggerFactory.getLogger(CounterDemo.class);

    public static class CountableData implements Countable{
        public CountableData(int value) {
            this.value = value;
        }

        public int value;
    }

    @Sync // 同步计算
    // 累计的计数器
    public static class TotalCounter implements Counter<CountableData>{
        private AtomicInteger total = new AtomicInteger(0);
        @Override
        public void count(CountableData value) {
            log.debug("{} + {} = {}", total.get(), value.value, total.addAndGet(value.value));
        }
    }

    // 最大最小值的计数器
    public static class MinMaxCounter implements Counter<CountableData> {
        private int min = Integer.MAX_VALUE, max = 0;

        @Override
        public void count(CountableData value) {
            int v = value.value;
            if (min > v)
                min = v;
            if (max < v)
                max = v;
            log.debug("min: {}, max: {}", min, max);
        }
    }

    // 数据分区的计数器，支持时序分段统计
    public static class BoxedCounter implements SegmentedCounter<CountableData> {

        private static final int boxCount = 15;
        private static final int boxSize = 100;
        private int[] boxes = new int[boxCount + 1];

        public BoxedCounter() {
            Arrays.fill(boxes, 0);
        }


        @Override
        public void count(CountableData value) {
            int boxNo = value.value / boxSize;
            boxes[Math.min(boxNo, boxCount)]++;
            log.debug("boxes: {}", boxes);
        }

        public int[] getBoxes() {
            return boxes;
        }

        @Override
        public Segmentation getSegmentation() {
            // 每三秒一个分段
            return new SpecificMomentSegmentation("*/3 * * * * *");
        }

        @Override
        public void slice() {
            log.info("slice ...");
            Arrays.fill(boxes, 0);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            CounterFacade.count(new CountableData(Common.random(0, 2000)));
            Thread.sleep(50);
        }

        ExecutorsHelper.shutdownAll();
    }

}
