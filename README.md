# exercise 介绍

exercise 是为了整理之前 Java 学习的内容，复用之前的部分代码，结合未来 Java 学习的路线搭建的一个仓库，方便自己在 GitHub 上进行代码的管理，使用 Git 进行本地代码的管理，记录自己学习之路，保存自己的代码，方便自己的学习的同时希望可以帮助其他人学习，同时希望大家在学习编程这条道路上互相帮助，共同进步。代码编写一定具有条理，一定要对方法以及携带的参数进行注释说明作用。

从代码实践中学习理论是最快的途径。因为我想，所以我在实践。
# GitHub

`GitHub` 是一个在线软件源代码托管服务平台，使用 `Git` 作为版本控制软件。

Git 不仅仅是个版本控制系统，它也是个内容管理系统 `CMS`，工作管理系统。`Git` 官网下载  https://git-scm.com/downloads

GitHub 创建仓库并上传项目代码，仓库建好之后，将`main`分支修改为 `master`，之后一个即可，方便自己代码上传，在 `Setting / Developer settings` 中

下载 `Git` ，在本地要上传的的文件夹右键进入`Git` 的命令行工具 `Git Bash Here`，每次需要先上传代码到本地仓库，提交到本地仓库，关联过情况下，直接上传代码到远程即可。
```bash
# 输入个人信息，代码提交者
git config --global user.name "666" 
git config --global user.email 123456@qq.com

# 本地项目目录创建本地仓库
git init

# 上传所有代码到本地仓库
git add .

# 代码提交仓库
git commit -m "initial commit"

# 关联本地仓库
git remote add origin https://github.com/NikeKlaus/exercise.git

# 上传代码
git push origin master

# 出现 [rejected]   master -> master (fetch first) error: failed to push some refs
# 跟刚创建的线上远程仓库的默认分支 master 关联
git pull --rebase origin master

# 出现 fatal: unable to access 'url': OpenSSL SSL_read: Connection was reset, errno 10054，解除 ssl 验证
git config --global http.sslVerify "false"
```


# IDEA快捷键

IDEA官网：[IntelliJ IDEA (jetbrains.com)](https://www.jetbrains.com/zh-cn/idea/download/other.html)

![1693741551154](E:\183-学习\计划\assets\1693741551154.png)

下载IDEA，这里可以找到所有版本的IDEA，下载好之后无脑安装即可，打开IDEA之后进入配置页面，

![1693741921882](E:\183-学习\计划\assets\1693741921882.png)

修改maven的环境配置

![1693741998429](E:\183-学习\计划\assets\1693741998429.png)

更改JavaScript规范级别

![1693742160122](E:\183-学习\计划\assets\1693742160122.png)

Tab空格设置，默认是正确的，需要检查下，不勾选，缩进为 4

![1693742321683](E:\183-学习\计划\assets\1693742321683.png)

配置JDK，版本和JDK版本对应

![1693742459118](E:\183-学习\计划\assets\1693742459118.png)

java编译的字节码文件和JDK的版本一致

![1693742529839](E:\183-学习\计划\assets\1693742529839.png)

版本控制的路径，如果有多个版本控制同一个，就会发生版本控制冲突，需要删除错误的版本控制

![1693742754656](E:\183-学习\计划\assets\1693742754656.png)

IDEA常用快捷键

搜索：CTRL + N，连续按两次 SHIFT 按键，快速跳出搜索界面

代码格式化：CTRL + ALT + L

导包优化：CTRL + ALT + O

包围方式：CTRL + ALT + T

当前类查找方法：CTRL + F12

修改类名并且修改文件名：Shift + F5

# backproject

放置项目工程，目前进行一个`java`社区项目的开发

# javabase

`java` 基础知识的学习，包含了集合，中间件，工具类

# javanote

`java` 的面经和总结的笔记

# springcloud

微服务项目的测试