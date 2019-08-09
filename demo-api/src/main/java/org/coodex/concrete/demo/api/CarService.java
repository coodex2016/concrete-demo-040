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
import org.coodex.concrete.demo.pojo.CarInfo;
import org.coodex.mock.Mock;
import org.coodex.mock.ext.VehicleNum;

@ConcreteService("cars")
@Description(name = "车辆资源服务", description = "文档化示例")
public interface CarService {

    @ConcreteService("/{id}/PlateCode")
    @VehicleNum
    @Description(name = "获取车牌号", description = "根据一辆车的id获取它车牌号")
    String getCarNumberById(
            @Description(name = "车辆id")
            @Mock.String
            String id);

    @ConcreteService("/{id}")
    @Description(name = "获取一辆车的信息", description = "数据包括车牌号车牌颜色等")
    CarInfo getCarById(
            @Description(name = "车辆id")
            @Mock.String
            String id);


    @Deprecated
    @Mock.Number("[3,9]")
    Integer warningExample();
}
