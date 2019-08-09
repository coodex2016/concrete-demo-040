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

import org.coodex.concrete.common.Account;
import org.coodex.concrete.common.NamedAccount;
import org.coodex.concrete.common.Token;
import org.coodex.concrete.demo.api.excepted.AbstractLibrary;
import org.coodex.concrete.demo.pojo.Book;
import org.coodex.util.Common;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.Map;

import static org.coodex.concrete.common.ConcreteContext.getLoggingData;

public abstract class AbstractLibraryImpl<B extends Book> implements AbstractLibrary<B> {
    private static final String[] attr = new String[]{
            "大胆的", "愤怒的", "没脑子的"
    };

    private static final String[] names = new String[]{
            "小明", "小红", "小强"
    };
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Inject
    private Token token; // 令牌里存放着用户信息

    protected abstract Map<String, Book> getBooks();

    protected abstract String getType();

    private String getAccountName() {
        Account account = token.currentAccount();
        if (account instanceof NamedAccount) {// NamedAccount是
            return ((NamedAccount) account).getName();
        }
        return Common.random(names) + "(化名)";
    }

    private String getAttr() {
        return Common.random(attr);
    }

    @Override
    public void delete(String name) {
        if (getBooks().containsKey(name)) {
            Book book = getBooks().remove(name);
            getLoggingData().put("book", book);
            log.info("{} {} 把 {} 图书[{}]销毁了。", getAttr(), getAccountName(), getType(), book);
        } else {
            log.info("nothing happened.");
        }
    }

    @Override
    public void sort() {
        int count = getBooks().size();
        getBooks().clear();
        if(count > 0){
            getLoggingData().put("count", count);
        }
        log.info("哦嚯，{} {} 把 {} 图书全部销毁了。", getAttr(), getAccountName(), getType());
    }
}
