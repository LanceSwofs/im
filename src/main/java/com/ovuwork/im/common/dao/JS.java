package com.ovuwork.im.common.dao;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JS {

	 public static Object run(String filename, Object... param) {
		 try {
        	String[] names = filename.split("/");
        	String file = names[0];
        	String method = names[1];
        	
	        	//加载当前class目录下的js文件
        	//BufferedReader buf = new BufferedReader(new InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream("/script/"+file))); 
        	BufferedReader buf = new BufferedReader(new InputStreamReader(JS.class.getResourceAsStream("/script/"+file)));
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
}
