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
import org.coodex.concrete.common.Token;
import org.coodex.concrete.demo.api.excepted.DemoLoginService;
import org.coodex.concrete.demo.impl.account.DemoAccountFactory;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class DemoLoginServiceImpl implements DemoLoginService {

    @Inject
    private Token token;

    @Override
    public void login(String id) {
        token.setAccount(
                IF.isNull(
                        DemoAccountFactory.getAccount(id),
                        // 这个用法不规范，应该先定义ErrorCode，然后编写异常资源信息在此使用ErrorCode
                        "none this account: " + id
                        )
        );
        // 该用户是可信的，与@safely注解有关，详见concrete-api说明
        token.setAccountCredible(true);
    }
}
