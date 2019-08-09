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

import org.coodex.concrete.common.Token;
import org.coodex.concrete.demo.api.TokenDemoService;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class TokenDemoServiceImpl implements TokenDemoService {

    private final static String TOKEN_KEY = "DEMO_KEY";

    @Inject // <-- 注入token
    private Token token;

    @Override
    public String getTokenValue() {
        return token.getAttribute(TOKEN_KEY, String.class);
    }

    @Override
    public void setTokenValue(String value) {
        token.setAttribute(TOKEN_KEY, value);
    }
}
