package it.nerd.basic;

public class MyClass implements MyInterface {

	public static void main(String[] args) {
		System.out.println("GO!!");

		Foo foo = new Foo();
		Bar bar = new Bar();
		foo.setPropertyA(1);
		foo.setPropertB(null);

		bar.setPropertyA(foo.getPropertyA());
		bar.setPropertB(foo.getPropertB());

		System.out.println(bar.getPropertB());

	}

	@Override
	public void bar() {
		// TODO Auto-generated method stub
	}

	public void myOverloading(String paramA) {
	}

	public void myOverloading(String paramA, String paramB) {
	}

}
