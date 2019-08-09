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

package org.coodex.concrete.demo.api;

import org.coodex.concrete.api.ConcreteService;
import org.coodex.concrete.api.Description;
import org.coodex.mock.Mock;
import org.coodex.mock.ext.FullName;

@ConcreteService("SubjoinExample")
public interface SubjoinExampleService {

    @Description(name = "向某人say hello",
            description = "当此人为第一次访问时，我们通过subjoin返回新用户的信息")
    String sayHello(
            @FullName // 在swagger中生成一个姓名的样例数据
                    String name);

    @Description(name = "由开发者手动设置warning data的示例",
            description = "同之前的案例一样，不过把异常改为警告，当加数和被加数不是个位数时，向调用者发送一个太难了的警告")
    Integer add(
            @Mock.Number("[0,20]")
                    Integer x1,
            @Mock.Number("[0,20]")
                    Integer x2);

}
