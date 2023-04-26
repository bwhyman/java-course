## 实验四 集合与函数式编程实验
### 实验目的
理解Java集合的适用场景  
掌握集合的添加/获取/遍历/移除等基本操作方法  
理解函数式编程思想  
掌握Lambda表达式的声明编写规范  
理解函数式接口  
掌握基于集合Stream API的过滤/映射/聚合等操作方法  
掌握基于函数式编程集合元素的移除方法  

### 实验内容
创建实验项目工程java-experiments  
在com.experiment04.entity下，创建Student实体类。包含，id，姓名，性别等属性  
在com.experiment04.resource下，创建DatabaseUtils类，添加模拟若干对象  
在com.experiment04.service下，StudentService接口中已声明基于集合流操作的方法    
在com.experiment04.service.impl下，创建StudentService接口的实现类StudentServiceImpl，
在接口实现类StudentServiceImpl中，调用DatabaseUtils类获取集合资源(对外隐藏数据源)，基于集合stream等操作，按接口方法注释需求实现   
理解项目的包结构  

在com.experiment04下，创建Test类  
为每个接口方法创建静态测试方法，在主函数调用  
**面向接口编程**，测试StudentService接口中方法的实现  



