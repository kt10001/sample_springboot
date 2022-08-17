#!/bin/bash
# 进程关键字，查看进程是否启动
PROCESS_KEY="99ke.jar"

# 从package.tgz中解压出来的jar包放到这个目录下
APP_HOME=/usr/local/zyke
# jar包的名字
JAR_NAME=99ke.jar
# 项目名称
APP_NAME=zyke
# jar包路径
JAR_PATH=$APP_HOME/$JAR_NAME
# 流水线tar包路径
LSX_TAR_PATH=/home/admin/zyke/package.tgz

function start() {
  echo ">>>>>> param1: $1 param2: $2"
  # 删除jar包
  rm -rf JAR_PATH
  # 解压
  tar -zxvf $LSX_TAR_PATH -C $APP_HOME
  # 启动项目进程 命令行指定配置文件
  nohup java -jar $JAR_PATH --spring.profiles.active=$2 &
  # 检查是否启动成功
  check_ins

}

function stop() {
  echo ">>>>>> 备份"
  rm -rf /usr/local/zyke/99ke.jar.bak
  cp /usr/local/zyke/99ke.jar /usr/local/zyke/99ke.jar.bak
  echo ">>>>>> 停止服务"
  pid=$(ps -ef | grep $PROCESS_KEY | grep -v grep | grep -v deploy.sh | awk '{print $2}')
  if [ "$pid" == "" ]; then
    echo ">>>>>> 服务未启动"
  else
    kill -15 $pid
    sleep 5
    echo ">>>>>> 服务停止完成"
  fi
}

function check_ins() {
  # 检查项目是否正常启动
  sleep 20
  CHECK=$(curl -H "Content-Type:application/json" -H "Data_Type:msg" -X POST --data '{}' http://127.0.0.1:9900/zyk/h5/product/list)
  data=$(echo $CHECK | grep 'CD0000')
  if [ -z "$data" ]; then
    echo ">>>>>> 服务启动失败"
  else
    echo ">>>>>> 服务启动成功"
    exit 0
  fi
  exit 122
}

function main() {
  echo ">>>>>> 开始执行部署脚本"
  echo ">>>>>> param1: $1 param2: $2"
  if [ "$1" == "start" -o "$1" == "restart" ]; then
    stop
    start $1 $2
  elif [ "$1" == "stop" ]; then
    stop
  fi
}

main $1 $2