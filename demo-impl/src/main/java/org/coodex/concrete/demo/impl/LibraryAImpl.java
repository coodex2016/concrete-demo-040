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

import org.coodex.concrete.demo.api.excepted.LibraryA;
import org.coodex.concrete.demo.pojo.Book;
import org.coodex.concrete.demo.pojo.BookA;

import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;

@Named
public class LibraryAImpl extends AbstractLibraryImpl<BookA> implements LibraryA {

    private Map<String, Book> books = new HashMap<String, Book>() {{
        for (int i = 1; i < 10; i++)
            put("A" + i, new BookA("A" + i, "A" + i));
    }};

    @Override
    protected Map<String, Book> getBooks() {
        return books;
    }

    @Override
    protected String getType() {
        return "文史类";
    }
}
