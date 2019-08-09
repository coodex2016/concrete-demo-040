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

package org.coodex.concrete.demo.api.excepted;

import org.coodex.concrete.api.AccessAllow;
import org.coodex.concrete.api.ConcreteService;
import org.coodex.concrete.api.Description;
import org.coodex.concrete.api.LogAtomic;
import org.coodex.concrete.demo.pojo.Book;

@ConcreteService(
        value = "Books",
        nonspecific = true // 抽象的服务，此服务不会直接发布，concrete只会发布具体的服务
)
@AccessAllow(roles = "图书管理员") // 此服务的接口需要图书管理员角色，AccessAllow也可以用来修饰具体服务接口
public interface AbstractLibrary<B extends Book> {

    @Description(name = "销毁一本书", description = "够狠")
    @ConcreteService("{name}")
    @LogAtomic(category = "library", subClass = "delete") // <- log定义
    void delete(String name);

    @Description(name = "整理书架")
    @LogAtomic(category = "library", subClass = "sort") // <- log定义
    void sort();
}
