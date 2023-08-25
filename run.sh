# run.sh
# 切换到jar包目录下
cd /home/test
# 使环境变量生效
source /root/.bash_profile
# 运行项目
nohup /usr/java/jdk1.8.0_181-cloudera/bin/java -jar test.jar >/home/test/cicd.log 2>&1 &
echo "启动完成"