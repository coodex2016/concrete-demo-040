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

import org.coodex.concrete.core.License;
import org.coodex.util.Singleton;

import javax.inject.Named;
import java.util.Calendar;

@Named
public class DemoLicenseImpl implements License {

    // license到期日，通过改变到期日来演示效果
    private Singleton<Calendar> calendarSingleton = new Singleton<>(() -> {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 10);
        return calendar;
    });

    @Override
    public String check() throws OverdueException {
        Calendar now = Calendar.getInstance();
        Calendar deathLine = calendarSingleton.get();
        if (now.after(deathLine)) {
            throw new OverdueException("许可已超期");
        }
        // 如果3天以后到期，发警告
        now.add(Calendar.DATE, 3);
        if (now.after(deathLine)) {
            return "即将到期";
        }
        // 正常
        return null;
    }
}
