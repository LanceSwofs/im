package com.ovuwork.im.common.dao;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BuildSql {

    public static Object run(String filename, String method, Object... param) {
        try {
            //加载当前class目录下的js文件
            BufferedReader buf = new BufferedReader(new InputStreamReader(BuildSql.class.getResourceAsStream("/script/" + filename)));
            ScriptEngineManager scriptManager = new ScriptEngineManager();
            ScriptEngine js = scriptManager.getEngineByExtension("js");
            js.eval(buf);
            Invocable inv = (Invocable) js;
            return inv.invokeFunction(method, param);
        } catch (ScriptException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String sqlAt(String sqlat, Object params) {
        //生成脚本
        String[] names = sqlat.split("/");
        String fileName = names[0].endsWith(".js") ? names[0] : names[0] + ".js";
        Object result = run(fileName, names[1], params);

        return result.toString();
    }

    public static String sqlAt(String sqlat) {
        //生成脚本
        String[] names = sqlat.split("/");
        String fileName = names[0].endsWith(".js") ? names[0] : names[0] + ".js";
        Object result = run(fileName, names[1]);

        return result.toString();
    }

}
