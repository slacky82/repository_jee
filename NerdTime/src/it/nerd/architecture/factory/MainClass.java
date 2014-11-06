package it.nerd.architecture.factory;

public class MainClass {
	
	public static void mian(String args[]){
		Foo foo = new Foo();
		foo.setFieldA("fieldA");
		foo.setFieldB(new Double(0));
		Bar bar = new Bar();
		bar.setFieldA("fieldA");
		bar.setFieldB(1);
		MyClass myClassBar = MyFactory.buildBar(bar);
		MyClass myClassFoo = MyFactory.buildFoo(foo);		
	}

}
