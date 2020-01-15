# PWM
党务管理系统的设计与实现，包括文档、代码及相关资料。
简单的git使用教程：https://www.cnblogs.com/jackchensir/p/8306448.html

用命令将代码拉下来并提交的基本操作流程如下：
在成功安装git并完成配置后，首先找到自己的开发工具（Intellij idea）的工作空间，
在该文件夹下点击右键选中Git Bash Here(在此创建git的本地版本库)，随后执行以下
相关命令即可。

1.克隆主分支项目并新建分支

1.1 git clone "项目地址"         --克隆项目

1.2 cd PWM              --切换到项目路径下

1.3  git branch  zxg     --创建分支

1.4  git checkout zxg    --切换到该分支下

2.代码提交，并且更新代码（完成自己的代码编写之后进去Git Bash Here）

git add .                --将修改的文件加入暂存区

git commit -m "开发模块叙述"        --本次提交的内容描述

git checkout -          --切换到主分支

git pull                --将主分支上的代码拉取下来

git push                --将代码推送到远程分支上

push成功之后会有successful提示。
