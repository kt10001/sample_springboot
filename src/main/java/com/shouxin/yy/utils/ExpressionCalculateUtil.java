package com.shouxin.yy.utils;

import lombok.extern.slf4j.Slf4j;
import org.python.util.PythonInterpreter;

import java.util.Properties;

/**
 * 字符串表达式计算
 * @time 2022/5/16 2:11 下午
 * @Author feikong
 */
@Slf4j
public class ExpressionCalculateUtil {

    private static PythonInterpreter pyInterpreter = null;

    private static PythonInterpreter getPythonInterpreter() {
        if (pyInterpreter == null) {
            Properties props = new Properties();
            props.put("python.home", "../jython-2.7.0");
            props.put("python.console.encoding", "UTF-8");
            props.put("python.security.respectJavaAccessibility", "false");
            props.put("python.import.site", "false");
            Properties preprops = System.getProperties();
            PythonInterpreter.initialize(preprops, props, new String[0]);
            pyInterpreter = new PythonInterpreter();
            pyInterpreter.exec("import sys");
            pyInterpreter.exec("print 'prefix', sys.prefix");
            pyInterpreter.exec("print sys.path");
            pyInterpreter = new PythonInterpreter();
        }
        return pyInterpreter;
    }

    /**
     * python 字符串表达式计算
     * 格式
     *  result = 1000 >= 2000
     *  result = 'A' in ['A','B','C','D','M',]
     * @param expression
     * @return
     */
    public static Boolean boolExpression(String expression) {
        // fix 表达式执行错误 https://github.com/jython/jython/issues/186
        log.info("规则 表达式: {}", expression);
        expression = expression.replace("企业法人", "企业 法人");
        pyInterpreter = getPythonInterpreter();
        pyInterpreter.exec(expression);
        boolean result = "True".equals(pyInterpreter.get("result").toString());
        log.info("规则 结果: {}", result);
        return result;
    }

    public static void main(String[] args) {
        boolExpression("result = 1 <= 1");
    }
}
