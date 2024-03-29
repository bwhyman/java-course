## 实验七 多线程并发实验
### 实验目的
理解多线程并发的作用预意义  
理解并掌握基于Runnable创建任务的方法  
理解并掌握线程的创建方法  
理解并掌握线程的休眠/中断操作方法  
理解并掌握多线程操作下方法的同步锁定  
理解并掌握多线程操作下对象的同步锁定 

### 实验内容
**需求**  
共200张哈尔滨至北京火车票，通过程序模拟实现3个售票点同时售票的功能。  
注意：考虑线程同步，同步如何设计，避免出现重复卖票。  

**分析设计**  
车票，包含ID，始发站名称，终点站名称。  
铁道部，包含200张哈尔滨至北京的车票，为所有售票点提供拿票业务逻辑。  
售票点，包含名称，以及售出的车票列表。售票业务逻辑，售票点从铁道部拿票，
成功后将拿到的票置于销售点的车票销售列表，同时模拟随机50毫秒内的其他业务逻辑操作(即sleep)。  
此实验，将业务逻辑代码预实体类代码整合。  

创建Test测试类，主函数。编写测试方法，创建3个售票点同时售票，每个售票点200人抢票，即共有600人同时抢票直到车票售空，打印显示每个售票点的销售数，与实际车票总数是否相同。  