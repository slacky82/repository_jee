package it.nerd.pattern.abstractfactory;

public class ColorFactory extends AbstractFactory {

	@Override
	Color getColor(String color) {
		if (color==null){
			return null;
		}
		if("RED".equalsIgnoreCase(color)){
			return new Red();
		}
		if("GREEN".equalsIgnoreCase(color)){
			return new Green();
		}
		if("BLUE".equalsIgnoreCase(color)){
			return new Blue();
		}
		return null;
	}

	@Override
	Shape getShape(String shape) {
		// TODO Auto-generated method stub
		return null;
	}

}
