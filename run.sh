# run.sh
# 切换到jar包目录下
cd /home/test
# 杀死之前的项目进程。这里的cut -c9-14是截取进程id，不一定都是-c9-14
# 可以先运行ps -ef|grep java|grep GitHub_Action-0.0.1-SNAPSHOT.jar看一下进程id是第几位到第几位
# ps -ef|grep java|grep test.jar|cut -c9-14|xargs kill -9
echo ">>>>>> 停止服务"
pid=$(ps -ef | grep $PROCESS_KEY | grep -v grep | grep -v deploy.sh | awk '{print $2}')
if [ "$pid" == "" ]; then
echo ">>>>>> 服务未启动"
else
kill -9 $pid
echo ">>>>>> 服务停止完成"
fi
# 停5秒
sleep 5s
# 使环境变量生效
source /root/.bash_profile
# 运行项目
nohup java -jar test.jar >/home/test.log 2>&1 &
echo "启动完成"