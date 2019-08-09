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

package org.coodex.concrete.demo.pojo;

import org.coodex.concrete.api.pojo.StrID;

import java.util.ArrayList;
import java.util.List;

public class ExamplePojo {
    private String x1 = "随便什么吧";

    private List<StrID<String>> example = new ArrayList<StrID<String>>(){{
        for(int i =0;i < 3; i ++){
            StrID<String> stringStrID = new StrID<>();
            stringStrID.setId("id" + i);
            stringStrID.setPojo("我是POJO_" + i);
            add(stringStrID);
        }
    }};

    public String getX1() {
        return x1;
    }

    public void setX1(String x1) {
        this.x1 = x1;
    }

    public List<StrID<String>> getExample() {
        return example;
    }

    public void setExample(List<StrID<String>> example) {
        this.example = example;
    }
}
