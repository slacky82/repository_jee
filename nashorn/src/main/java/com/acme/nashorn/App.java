package com.acme.nashorn;

import java.io.FileReader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.Invocable;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String... args) throws Throwable {
		
		ScriptEngineManager engineManager = new ScriptEngineManager();
		ScriptEngine engine = engineManager.getEngineByName("nashorn");
		
		//case 1		
		engine.eval("function sum(a, b) { return a + b; }");
		System.out.println(engine.eval("sum(1, 2);"));
		
		//case 2
		Invocable invocable = (Invocable) engine;
		engine.eval(new FileReader("src/main/resources/dummy.js"));
		System.out.println(invocable.invokeFunction("hello", "foo", "bar"));
	}
}
