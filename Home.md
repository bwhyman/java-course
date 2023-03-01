# Development Environments
### Preparations

教学群下载2个文件准备。ideaIU-X.win.zip，settings.xml。  

不要着急运行idea，按以下步骤配置！~

### Maven & Settings

了解什么是Maven:  
https://mooc1.chaoxing.com/nodedetailcontroller/visitnodedetail?courseId=217339173&knowledgeId=416968558

Maven Settings的本地配置:  
https://mooc1.chaoxing.com/nodedetailcontroller/visitnodedetail?courseId=217339173&knowledgeId=726850150

Maven是当前主流的Java项目构建管理工具

基于Maven的项目依赖管理，maven首先从本地仓库查找依赖，没有则通过网络从远程仓库下载，因此，**第一次添加某依赖时，保持联网状态**

Idea已集成maven插件，但其默认配置不适于开发。因此，通过自定义maven配置，将maven管理的依赖文件下载到指定目录，同时添加阿里镜像，提高下载速度。

在合适目录，创建名为m2目录。例如，D:\m2

在其下创建repository目录，复制或创建maven配置文件settings. xml

**将localRepository节点，修改为自定义的repository目录地址**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<settings xmlns="http://maven.apache.org/SETTINGS/1.1.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.1.0 http://maven.apache.org/xsd/settings-1.1.0.xsd">
    <mirrors>
        <mirror>
            <id>huaweicloud</id>
            <mirrorOf>central</mirrorOf>
            <url>https://repo.huaweicloud.com/repository/maven/</url>
        </mirror>
        <mirror>
            <id>aliyunmaven</id>
            <mirrorOf>central</mirrorOf>
            <name>阿里云公共仓库</name>
            <url>https://maven.aliyun.com/repository/public</url>
        </mirror>
        <mirror>
            <id>nexus-tencentyun</id>
            <mirrorOf>central</mirrorOf>
            <name>Nexus tencentyun</name>
            <url>http://mirrors.cloud.tencent.com/nexus/repository/maven-public/</url>
        </mirror>
    </mirrors>
    <localRepository>D:/m2/repository</localRepository>
</settings>
```

### IntelliJ IDEA
**卸载系统中曾经安装过的Oracle JDK。idea已集成openjdk，无需安装**

有以下两种idea激活方法：通过校邮箱申请免费授权，破解激活

#### Free Educational Licenses
如，校email或教育授权申请失败，只能尝试破解方法激活idea

Idea Ultimate，为功能强大的付费版开发工具，但全球学生均可申请免费授权。

中国高校域名email，是受国际承认的正式的学生标识，许多公司(google/apple/amazon等)均为全球在读学生提供各种免费服务。

按国际惯例，邮箱账号为：名缩写+.+姓+数字，账号已被注册，则数字+1。
例如，账号：张小明，x.m.zhang17。Email地址：x.m.zhang17@nefu.edu.cn

或直接使用学号申请，例如：2018214270@nefu.edu.cn

联系研究生导师，出国留学申请等，均应使用正式的学生email邮箱

东北林业大学email申请

https://mail.nefu.edu.cn/register/register.jsp

https://mail.nefu.edu.cn/coremail/

 idea学生免费授权计划申请

https://www.jetbrains.com/zh/student/

使用学校email注册idea账号，建议idea账号即为email地址。注册成功后，idea向邮箱发送验证链接，接收到邮件可能有**20分钟的时间延长**

![image-20210302141801829](images/Home/image-20210302141801829.png)

![image-20210302141817487](images/Home/image-20210302141817487.png)

解压缩ideaIU-X.win.zip(文件名以下载版本为准)，到合适目录。例如，D:\idea

![image-20210302141951518](images/Home/image-20210302141951518.png)

运行D:\idea\bin\idea64.exe，启动idea。

输入学校邮箱创建的idea账号登录，进入welcome页面

![image-20210302142826048](images/Home/image-20210302142826048.png)

#### IDEA Crack
教学群下载ja-netfilter-all.zip。解压到合适目录，按激活方法破解激活

### IDEA Maven Settings
IDEA引入maven settings配置:   
https://mooc1.chaoxing.com/nodedetailcontroller/visitnodedetail?courseId=217339173&knowledgeId=726862579

### Maven Java Project
IDEA创建maven java project:   
https://mooc1.chaoxing.com/nodedetailcontroller/visitnodedetail?courseId=217339173&knowledgeId=416970143

### Optimizing IntelliJ IDEA
优化idea开发环境

![image-20210302143245749](images/Home/image-20210302143245749.png)

#### Code Completion

**关闭**代码提示的大小写匹配，提高开发效率

![image-20201029141538301](images/Home/image-20201029141538301.png)

#### Font Size & Style

自定义代码字体样式及尺寸

![image-20201029141618181](images/Home/image-20201029141618181.png)
