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