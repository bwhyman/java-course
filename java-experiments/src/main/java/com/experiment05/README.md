## 实验五 Optional操作实验
### 实验目的
理解解决Java空指针异常的重要性  
掌握Optional对空引用的基本操作方法  
掌握基于Optional的函数式编程  
掌握整合集合Stream与Optional的操作方法  

### 实验内容
创建实验项目工程java-experiments  
在com.experiment05.entity下，创建以下实体类  
College实体类，包含学院名称  
Teacher实体类，包含教师工号，姓名，及所属学院  
Student实体类，包含学号，姓名，年级，指导教师  

在com.experiment05.resource下，创建DatabaseUtils类  
模拟2个学院，2名教师，4名学生。模拟信息封装到各对象，创建一个学生集合封装所有学生测试    
基于Optional，按需求实现测试类Test中的方法，模拟正确/错误数据信息验证代码的有效性  


