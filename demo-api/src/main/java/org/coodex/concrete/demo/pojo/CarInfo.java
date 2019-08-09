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

        import org.coodex.concrete.api.Description;
        import org.coodex.mock.Mock;
        import org.coodex.mock.ext.FullName;
        import org.coodex.mock.ext.IdCard;
        import org.coodex.mock.ext.VehicleNum;

public class CarInfo {
    @VehicleNum
    @Description(name = "车牌号码")
    private String plateCode;
    @Mock.Number("[0,4],9")
    @Description(name = "车牌颜色", description = "按照国标定义")
    private Integer plateColor;

    @Description(name = "车主姓名")
    @FullName
    private String ownerName;
    @Description(name = "车主身份证号")
    @IdCard
    private String idCard;

    @Description(name = "车辆品牌")
    @Mock.String(range = {"兰博基尼", "玛莎拉蒂", "奔驰", "宾利", "奥迪", "宝马"})
    private String brand;

    public String getPlateCode() {
        return plateCode;
    }

    public void setPlateCode(String plateCode) {
        this.plateCode = plateCode;
    }

    public Integer getPlateColor() {
        return plateColor;
    }

    public void setPlateColor(Integer plateColor) {
        this.plateColor = plateColor;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
