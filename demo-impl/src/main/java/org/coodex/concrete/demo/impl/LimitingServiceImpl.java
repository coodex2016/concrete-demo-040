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

import org.coodex.concrete.demo.api.excepted.LimitingService;

import javax.inject.Named;

@Named
public class LimitingServiceImpl implements LimitingService {
    @Override
    public void demoMaximumConcurrency() {
        try {
            // 拖延十秒形成并发量
            Thread.sleep(10000);
        } catch (InterruptedException ignore) {
        }
    }

    @Override
    public void demoTokenBucket() {
        // doNothing
    }
}
