#!/bin/bash
# 进程关键字，查看进程是否启动
PROCESS_KEY="test.jar"

# 从package.tgz中解压出来的jar包放到这个目录下
APP_HOME=/home/test
# jar包的名字
JAR_NAME=test.jar
# 项目名称
APP_NAME=test
# jar包路径
JAR_PATH=$APP_HOME/$JAR_NAME

function start() {
  echo ">>>>>> param1: $1 "
  # 删除jar包
  rm -rf JAR_PATH
  # 启动项目进程 命令行指定配置文件
  nohup /usr/java/jdk1.8.0_181-cloudera/bin/java -jar /home/test/test.jar &
  sleep 5
  echo "启动完成"

}

function stop() {
  echo ">>>>>> 备份"
  rm -rf /home/test/test.jar.bak
  cp /home/test/test.jar /home/test/test.jar.bak
  echo ">>>>>> 停止服务"
  pid=$(ps -ef | grep $PROCESS_KEY | grep -v grep | grep -v deploy.sh | awk '{print $2}')
  if [ "$pid" == "" ]; then
    echo ">>>>>> 服务未启动"
  else
    kill -9 $pid
    sleep 5
    echo ">>>>>> 服务停止完成"
  fi
}

function main() {
  echo ">>>>>> 开始执行部署脚本"
  echo ">>>>>> param1: $1 "
  if [ "$1" == "start" -o "$1" == "restart" ]; then
    stop
    start $1
  elif [ "$1" == "stop" ]; then
    stop
  fi
}

main