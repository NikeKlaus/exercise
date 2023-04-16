# exercise 介绍

exercise 是为了整理之前 Java 学习的内容，复用之前的部分代码，结合未来 Java 学习的路线搭建的一个仓库，方便自己在 GitHub 上进行代码的管理，使用 Git 进行本地代码的管理，记录自己学习之路，保存自己的代码，方便自己的学习的同时希望可以帮助其他人学习，同时希望大家在学习编程这条道路上互相帮助，共同进步。代码编写一定具有条理，一定要对方法以及携带的参数进行注释说明作用。

从代码实践中学习理论是最快的途径。因为我想，所以我在实践。
# GitHub

GitHub 是一个在线软件源代码托管服务平台，使用 Git 作为版本控制软件。这是我GitHub的地址：https://github.com/NikeKlaus

Git 不仅仅是个版本控制系统，它也是个内容管理系统(CMS)，工作管理系统。Git 官网下载  https://git-scm.com/downloads

GitHub 创建仓库并上传项目代码，仓库建好之后，将 main 分支修改为 master，之后一个即可，方便自己代码上传，在 Setting / Developer settings 中



下载 Git ，在本地要上传的的文件夹右键进入 Git 的命令行工具 Git Bash Here，每次需要先上传代码到本地仓库，提交到本地仓库，关联过情况下，直接上传代码到远程即可。
```bash
# 输入个人信息，代码提交者
git config --global user.name "coffeemao" 
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

# 出现 fatal: unable to access 'url': OpenSSL SSL_read: Connection was reset, errno 10054
# 解除 ssl 验证
git config --global http.sslVerify "false"
```


# IDEA快捷键

IDEA官网：https://www.jetbrains.com/idea/

IDEA 层级展开包：选项 > 树外观 > 仅仅勾选：显示排除的文件，显示临时文件和控制台，文件夹总在最前

搜索：CTRL + N，连续按两次 SHIFT 按键，快速跳出搜索界面

代码格式化：CTRL + ALT + L

包围方式：CTRL + ALT + T