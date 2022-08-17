# 用友
h5半流程api信贷产品

## 开发规范
    1. 见文档 https://buershujv.yuque.com/wtbggi/so63yy/ig4gyh
    
    2. 接口请求方式只能使用post
       为什么见知乎：https://www.zhihu.com/question/336797348
            
    3. 数据库操作放在dao层， 禁止扩散到其他业务层
    
    4. controller 做参数校验， 返回结果包装
    
    5. service 不做参数校验，默认参数是正常的
       service 考虑作为一个公共接口，而不是只为一个controller提供服务
       
    6. 代码风格清晰，便于阅读
       6.1 逻辑清晰，功能1 2 3 4 一目了然
       6.2 封装，封装粒度要细，达到修改一个逻辑，其他不需要变动的效果
       
    7. 多打日志
       日志不要钱，放心打
       error日志会被预警通知出来，要合理打error日志
       
    8. 干掉所有重复操作
       如果发现有需要重复copy的代码，请把它解决   
   
    9. 实体类需要加注释
        DTO VO必须加
        
    10. 配置项使用
        redis -> mysql 
        先查询redis，没有查询mysql，查完写入redis，设置过期时间         


## 环境信息
    项目地址：
        sit: 
            h5: http://sit-yy.shouxin168.com/
        prod：
            h5: https://yy.shouxin168.com/
    
    服务器地址：
        sit: lighting-pre 47.103.33.79
        prod: zyk 47.103.44.162
    
    数据库：
        mysql：
            local：
                addr:   47.103.37.208
                port:   3306
                user:   root
                pwd:    Qwe123456.
                db:     yy
            sit:
                addr:   rm-uf63228wij45fi277uo.mysql.rds.aliyuncs.com
                port:   3306
                user:   yongyou
                pwd:    yy123888_
                db:     yy
                
            prod:
                addr:   rm-uf6mhn3b09ne1lo3tzo.mysql.rds.aliyuncs.com
                port:   3306
                user:   yongyou
                pwd:    yy123888_
                db:     yy
                
        redis：
            local:
                addr:   101.133.231.161
                port:   6379
                pwd:    redis-password
                db:     10
                shell: redis-cli -h 101.133.231.161 -p 6379 -a redis-password
            
            sit:
                addr:   r-uf6vypwfecklhwubno.redis.rds.aliyuncs.com
                port:   6479
                pwd:    redis@Password123
                db:     18
            
            prod:
                addr:   r-uf6vypwfecklhwubno.redis.rds.aliyuncs.com
                port:   6479
                pwd:    redis@Password123
                db:     19
    oss地址：
        oss-99ke.booleandata.cn
            
    文档仓：
        https://buershujv.yuque.com/wtbggi/labw1l/zr9cr9
    
    api管理：
        apipost

## 技术栈
    web框架       springboot
    ORM          mybatis-plus
    定时任务       quartz
    权限框架       shiro
    工具库（自有）  tennel
