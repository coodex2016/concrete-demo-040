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

package org.coodex.concrete.demo.impl;

import org.coodex.concrete.common.IF;
import org.coodex.concrete.demo.api.AddWithIn10Service;

import javax.inject.Named;

import static org.coodex.concrete.demo.api.DemoErrorCodes.TOO_HARD;

@Named
public class AddWithIn10ServiceImpl implements AddWithIn10Service {

    @Override
    public Integer add(Integer x1, Integer x2) {
        // IF是concrete工具链提供的工具之一
        // 下面的接口就是说，如果满足条件（参数1），则抛出TOO_HARD异常(参数2)，并传入信息渲染的参数（参数3，可变参数）
        IF.is(x1 < 0 || x1 > 9 || x2 < 0 || x2 > 9,
                TOO_HARD,
                x1, x2);
        return x1 + x2;
    }
}
