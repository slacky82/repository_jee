package it.nerd.architecture.factory;

public class MyFactory {

	public static MyClass buildFoo(Foo a) {
		MyClass myclass = new MyClass();
		myclass.setFieldA(a.getFieldA());
		myclass.setFieldB(a.getFieldB().intValue());
		return myclass;

	}

	public static MyClass buildBar(Bar b) {
		MyClass myclass = new MyClass();
		myclass.setFieldA(b.getFieldA());
		myclass.setFieldB(b.getFieldB());		
		return myclass;

	}

}
