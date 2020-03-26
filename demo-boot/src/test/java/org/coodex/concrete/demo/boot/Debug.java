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

import org.coodex.util.I18N;
import org.coodex.util.LazySelectableServiceLoader;
import org.coodex.util.SelectableServiceLoader;

public class Debug {

    private static final SelectableServiceLoader<Integer, NumberSelectableService> NUMBER_SERVICE_LOADER =
            new LazySelectableServiceLoader<Integer, NumberSelectableService>() {
            };

    public static void main(String[] args) {
        System.out.println(NUMBER_SERVICE_LOADER.select(0));// 获取到的是EvenNumberAcceptableService的实例
        System.out.println(NUMBER_SERVICE_LOADER.select(1));// 获取到的是OddNumberAcceptableService的实例
        System.out.println(I18N.translate("message.105001"));
    }


    public static class OddNumberSelectableService implements NumberSelectableService {
        @Override
        public boolean accept(Integer param) {
            return param != null && param % 2 == 1;
        }
    }

    public static class EvenNumberSelectableService implements NumberSelectableService {
        @Override
        public boolean accept(Integer param) {
            return param != null && param % 2 == 0;
        }
    }
}
