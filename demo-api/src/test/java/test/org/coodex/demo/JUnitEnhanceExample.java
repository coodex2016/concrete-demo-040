/*
 * Copyright (c) 2020 coodex.org (jujus.shen@126.com)
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

package test.org.coodex.demo;


import org.coodex.junit.enhance.Context;
import org.coodex.junit.enhance.CoodexEnhanceTestRule;
import org.coodex.util.Common;
import org.junit.Rule;
import org.junit.Test;

import static org.coodex.junit.enhance.TestUtils.TIME;
import static org.coodex.junit.enhance.TestUtils.logger;

public class JUnitEnhanceExample {

    // 使用coodex enhance rule
    @Rule
    public CoodexEnhanceTestRule testRule = new CoodexEnhanceTestRule();

    @Test
    @Context(name = "如不指定会用方法名")
    public void test1() {
        logger.info("now {}", Common.now());
        /**
         * 时间跳转到明年元旦，TestUtil.TIME提供了丰富的接口
         *
         * @see org.coodex.junit.enhance.TestUtils.Time
         */
        TIME.nextYear();
        logger.info("now {}", Common.now());
    }

    @Test
    public void test2() {
        logger.info("第二个测试场景");
    }

}
