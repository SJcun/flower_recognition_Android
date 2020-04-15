# 基于移动终端的花卉识别系统--Android

#### 介绍

&emsp;&emsp;基于移动终端的花卉识别系统（Android仓库）

&emsp;&emsp;python开发的分类器，java开发的安卓软件

&emsp;&emsp;现在我想把这两部分分到两个仓库中，**本仓库是安卓软件**，分类器部分请查看另一仓库。

&emsp;&emsp;Android开发语言：Java，使用开发工具：Android Studio

#### 主界面

<img src="https://raw.githubusercontent.com/SJcun/Picture/master/img_new/%E6%88%AA%E5%B1%8F_20200415_184023.jpg" width="25%" height="25%" alt="截屏_20200415_184023" />

界面包含了一个图片，两个按钮。

图片代表了软件的logo，`花容`取自唐代诗人李白的诗文“云想衣裳花想容”，虽然这一句的本意是表达杨贵妃的美丽，但是拿来表达花的美丽也未尝不可。

两个按钮就很简单了，分别是启动`相机`功能和`相册提取`功能。

#### 相机

这里面主要用到的是google支持的`camera2`接口，不过这个也算是比较老的了，近年来有推出`cameraX`，感兴趣的朋友可自行搜索。

点击主界面的`相机`进入相机拍摄（目前有概率性黑屏的问题）

<img src="https://raw.githubusercontent.com/SJcun/Picture/master/img_new/%E6%88%AA%E5%B1%8F_20200415_185738.jpg" width="25%" height="25%" alt="截屏_20200415_185738" />

这个界面分为两部分，上部分用来实时预览镜头内的内容，下部分只包含了一个`拍照`按钮（虽然这个按钮现在看起来还有点丑，但是目的是先实现功能，再去考虑美观的问题）

点击`拍照`，就会把镜头拍摄到的画面展示到用户面前

<img src="https://raw.githubusercontent.com/SJcun/Picture/master/img_new/%E6%88%AA%E5%B1%8F_20200415_185747.jpg" width="25%" height="25%" alt="截屏_20200415_185747"  />

这个界面展示的是用户拍摄的画面，下部分包含一个按钮，点击`确定`就会将图片上传到服务器中，在`花卉识别`中可以用来检测花卉的种类。（目前，`确定`按钮功能尚未完成）

#### 相册

点击主界面的`相册`，就会进入用户终端的本地相册



<img src="https://raw.githubusercontent.com/SJcun/Picture/master/img_new/%E6%88%AA%E5%B1%8F_20200415_190921.jpg" width="25%" height="25%" alt="截屏_20200415_190921"  />

选择其中一张图片，就会跳转到预览界面

<img src="https://raw.githubusercontent.com/SJcun/Picture/master/img_new/%E6%88%AA%E5%B1%8F_20200415_190931.jpg" width="25%" height="25%" alt="截屏_20200415_190931" />

同样是点击`确定`按钮就会把图片上传至服务端。



