# 车辆资源服务

* **模块名称：** /Cars
* **模块定义：** org.coodex.concrete.demo.api.CarService


文档化示例

## 接口
### <span id="m1">~~/warningExample~~</span>





* **path:** /Cars/warningExample
* **Http Method:** GET
* **acl:** Anonymous
* **return:** Integer
* **params:** NONE

### <span id="m2">获取车牌号</span>

根据一辆车的id获取它车牌号



* **path:** /Cars/{id}/PlateCode
* **Http Method:** GET
* **acl:** Anonymous
* **return:** String
* **params:** 

| ParamName | Method | Label | Type                  | Description |
| --------- | -- | ---- | --------------------- | ------------ |
| id |  | 车辆id | String | 　 |

### <span id="m3">获取一辆车的信息</span>

数据包括车牌号车牌颜色等



* **path:** /Cars/{id}
* **Http Method:** GET
* **acl:** Anonymous
* **return:** [CarInfo](../pojos/org.coodex.concrete.demo.pojo.CarInfo.md)
* **params:** 

| ParamName | Method | Label | Type                  | Description |
| --------- | -- | ---- | --------------------- | ------------ |
| id |  | 车辆id | String | 　 |

