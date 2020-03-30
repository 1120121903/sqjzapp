# sqjzapp  社区矫正-服刑人员app演示版
 
##   代码规范

## 控件使用

### 1、页面元素绑定 -butterknife
 页面元素绑定使用butterknife插件，在创建完layout.xml文件后，在create文件中绑定layout。
 ```java
 setContentView(R.layout.activity_onlinesignin);
 ```
 将鼠标移动到R.layout.activity_onlinesignin上，键盘敲击alt+insert，选择generate butterknife injection引用。
 引用完成后格式如下：
 ```java
    @BindView(R.id.tb_onlinesignin_titlebar)
    TitleBar tbOnlinesigninTitlebar;
    @BindView(R.id.map)
    MapView mapView;
 ```

### 2、动态权限申请 -Rxpremission
android6.0之后，有关用户隐私的权限需要动态申请才可以使用。因此使用Rxpremission来进行动态权限申请。
首先在项目的gradle中引入jitpack库：
```java
allprojects {
    repositories {
        google()
        jcenter()
        maven { url 'https://jitpack.io' }
    }
}
```
动态权限申请使用Rxpremission（基于Rxjava2），在gradle(app)中添加依赖：
```java
/*RxPremission 申请权限 (需要与Rxjava2配套使用)*/
    implementation 'com.github.tbruyelle:rxpermissions:0.10.2'
```
使用方法：以定位需要使用的两个权限为例，<br>
Manifest.permission.ACCESS_COARSE_LOCATION  粗略定位
Manifest.permission.ACCESS_FINE_LOCATION 精细定位
```java
//定义一个final变量
final RxPermissions rxPermissions = new RxPermissions(this);
```
```java
//使用方法
rxPermissions.request(Manifest.permission.ACCESS_COARSE_LOCATION,
                              Manifest.permission.ACCESS_FINE_LOCATION)
                    .subscribe(granted ->{
                        if(granted){
                           //获取成功
                        }else{
                            //获取失败
                        }
                    });
                    });
```
