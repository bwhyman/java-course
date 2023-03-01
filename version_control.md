# Version Control

课程全部代码将推送到GitHub，建议了解基本git/github的使用方法

### Git

**Git必须安装到英文路径，建议仅更改盘符**

运行安装程序后，除安装地址外，其他选项全部默认

![image-20210302192303482](images/Home/image-20210302192303482.png)

可以取消安装，windows explorer integration下的，git bash here，git GUI here

**不要修改其他所有过程选项，全部默认即可**

安装成功后，可在控制台查看git信息

![image-20210302192344231](images/Home/image-20210302192344231.png)

**重启IDEA，IDEA可以自动找到git安装路径**

### GitHub

课程不要求学生一定掌握，基于github实现对自己代码本地/远程版本控制的方法(后续课程开始必须掌握)。但强烈建议学生先自行学习了解。

个人github仓库，是找工作/保研/考研，向别人展示自己能力必须提供的证明

### Cloning Remote Project

为便于学习，课程通过创建一个项目(project)，在项目中创建若干模块(module)实现。因此，仅需从github clone一次项目，每次拉取更新即可。

可以在此项目中创建自己的学习测试module，不会影响到课程代码

**确定系统已安装git**

返回welcome页面。选择获取远程项目

![image-20210302192909130](images/Home/image-20210302192909130.png)

定位到工作区，复制课程仓库地址。idea将自动创建项目目录，clone项目到工作区目录

https://github.com/bwhyman/java-course

![image-20210302193022012](images/Home/image-20210302193022012.png)

打开左侧project视图，clone下的项目与开发时的项目完全相同

![image-20210302194202184](images/Home/image-20210302194202184.png)

### Updating Remote Peoject

课程代码更新后会推送到github，，需更新项目拉取最新的代码

![image-20201029143332326](images/Home/image-20201029143332326.png)

### Create New Module

可以在此项目中创建自己的学习测试module

![image-20210302194539619](images/Home/image-20210302194539619.png)

基本maven module

![image-20210302194659665](images/Home/image-20210302194659665.png)

模块名称不能冲突，可以以用户名命名。自动在项目下创建同名目录

![image-20210302194819136](images/Home/image-20210302194819136.png)

### Delete Module

在项目中删除不需要的module

为防止误操作，idea禁止直接删除项目中的模块。需要先将模块从项目移除，此时模块所有文件均没有从磁盘删除，还可重新导入

![image-20210302195101326](images/Home/image-20210302195101326.png)

再次，从磁盘删除

![image-20210302195209453](images/Home/image-20210302195209453.png)

打开项目pom.xml配置，其中模块声明没有被自动删除。手动删除即可

![image-20210302195305341](images/Home/image-20210302195305341.png)
