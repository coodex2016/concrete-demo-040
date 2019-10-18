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
import org.coodex.concrete.common.Production;
import org.coodex.concrete.common.ProductionRepository;
import org.coodex.concrete.demo.impl.account.DemoAccountFactory;
import org.coodex.util.Common;
import org.coodex.util.Profile;

import javax.inject.Named;
import java.text.ParseException;
import java.util.*;

@Named
public class DemoProductionRepository implements ProductionRepository {
    @Override
    public List<Production> getProductionsBy(Account account, String[] modules) {
        final DemoAccountFactory.DemoAccount demoAccount = (DemoAccountFactory.DemoAccount) account;
        return Collections.singletonList(new Production() {
            private String name = "P_" + demoAccount.getId();
            private Profile profile = Profile.get(name);
            private Set<String> modules = new HashSet<>(Arrays.asList(profile.getStrList("modules")));

            @Override
            public Calendar getCalendar() {
                try {
                    return Common.strToCalendar(profile.getString("validate"), Common.DEFAULT_DATE_FORMAT);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }

            @Override
            public Integer getRemindDays() {
                return 7;
            }

            @Override
            public String getProductionName() {
                return name;
            }

            @Override
            public Set<String> getModules() {
                return modules;
            }
        });
    }

    @Override
    public boolean accept(Account param) {
        return param instanceof DemoAccountFactory.DemoAccount;
    }
}
