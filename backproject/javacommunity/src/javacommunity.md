1、什么时间使用枚举，什么时间使用常量类？

2、模型分层与manager的调度如何分解？

a、数据模型entity层，数据操作mapper、service层，模型model层负责业务的管理与编写，controller调用

3、国际化等静态资源如何存放？

a、resource目录下

4、前后端分离，同一个登录界面，选择管理员或者用户？

a、公用同一个登录界面和系统，管理员具有一个管理中心的大菜单，普通管理员可以进行部分的管理，唯一的超级管理员权限最大。

5、数据库一次查询缓存，减少数据库的I/O次数，数据库的使用，MySQL，Redis、文档型数据库，时序数据库，数据库管理？

6、如何实现加密、解密算法、校验、安全框架？

a、X509的RSA和ECC，国密加密算法

b、Spring Security 集成权限管理

7、自动化部署、测试、联调？

a、ApiFox 开源配置，脚本编写

8、日志分析与展示，EasyExcel 使用？

9、流程顺序执行原子性的保证？

10、多线程访问、负载均衡和反向代理，服务治理，监控诊断？

11、单体拆分，多模块的微服务、集群搭建？

12、邮箱或者手机号验证码，图片的验证码登录？

13、备忘录模式，记录删除、修改的操作

14、唯一的超级管理员和管理员区别，权限最大，可以识别到修改的数据

15、地区数据的建立、插入、初始化、备份数据

16、每写的每一行代码都要考虑存在的意义，代码的位置，代码可能出现的问题，|| 运算小心空指针异常，在解决这个问题过程中可能连续引发那些问题？

17、lombook，idea，jdk 问题

18、数据库字段范围控制

19、今天把表增删查改做完，确定要做那些模块