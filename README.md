# sqjzapp  社区矫正-服刑人员app演示版
目录：
- [sqjzapp  社区矫正-服刑人员app演示版](#sqjzapp-%e7%a4%be%e5%8c%ba%e7%9f%ab%e6%ad%a3-%e6%9c%8d%e5%88%91%e4%ba%ba%e5%91%98app%e6%bc%94%e7%a4%ba%e7%89%88)
  - [代码规范](#%e4%bb%a3%e7%a0%81%e8%a7%84%e8%8c%83)
    - [1、layout.xml中的元素id命名](#1layoutxml%e4%b8%ad%e7%9a%84%e5%85%83%e7%b4%a0id%e5%91%bd%e5%90%8d)
    - [2、string字符串标签](#2string%e5%ad%97%e7%ac%a6%e4%b8%b2%e6%a0%87%e7%ad%be)
  - [控件使用](#%e6%8e%a7%e4%bb%b6%e4%bd%bf%e7%94%a8)
    - [1、页面元素绑定 -butterknife](#1%e9%a1%b5%e9%9d%a2%e5%85%83%e7%b4%a0%e7%bb%91%e5%ae%9a--butterknife)
    - [2、标题栏 -TitleBar（自定义插件）](#2%e6%a0%87%e9%a2%98%e6%a0%8f--titlebar%e8%87%aa%e5%ae%9a%e4%b9%89%e6%8f%92%e4%bb%b6)
    - [3、动态权限申请 -Rxpremission](#3%e5%8a%a8%e6%80%81%e6%9d%83%e9%99%90%e7%94%b3%e8%af%b7--rxpremission)

##   代码规范
### 1、layout.xml中的元素id命名
>格式：控件名_文件名_自定义


例如：<br>
activity_login.xml中填写name的EditText元素的命名为：et_login_name

``` xml
 <EditText
                android:id="@+id/et_login_name"
                android:layout_width="200dp"
                android:layout_height="wrap_content"/>
```
### 2、string字符串标签
>格式：每个模块使用自己的string.xml文件，命名为:string_模块名.xml<br>
模块内的字符串元素命名为：模块名_元素缩写_自定义 

例如：<br>
网上签到模块中的string文件为：string_onlinesignin.xml
文件内的string写法为：
```
<!--网上签到页面-->
    <string name="onlinesignin_titlebar">网上签到</string>
    <string name="onlinesignin_tv_mylocation">我的位置:</string>
```

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
### 2、标题栏 -TitleBar（自定义插件）
在layout.xml文件中加入标题栏
```xml
<!--顶部标题栏-->
    <com.hjq.bar.TitleBar
        android:visibility="visible"
        android:id="@+id/tb_onlinesignin_titlebar"
        android:layout_width="wrap_content"
        android:layout_height="40dp"
        android:background="@color/green"
        app:titleColor="@null"
        app:leftBackground="@null"
        app:rightBackground="@null"
        app:barStyle="transparent"
        app:leftTitle="@string/title_back"
        app:rightSize="0dp"
        app:title="@string/onlinesignin_titlebar" />
```
在Activity的oncreate方法中对标题栏进行设置：
```java
//其中 第一个param是绑定的layout中的顶部标题栏元素，
//第二个是当前activity的context
ActivityCollector.TitleCilckListener(tbOnlinesigninTitlebar, this);
```

### 3、动态权限申请 -Rxpremission
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
