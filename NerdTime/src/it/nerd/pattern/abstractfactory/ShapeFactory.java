package it.nerd.pattern.abstractfactory;

public class ShapeFactory extends AbstractFactory {

	@Override
	Color getColor(String color) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	Shape getShape(String shape) {
		if (shape==null){
			return null;
		}
		if("RECTANGLE".equalsIgnoreCase(shape)){
			return new Rectangle();
		}
		if("CIRCLE".equalsIgnoreCase(shape)){
			return new Circle();
		}
		if("SQUARE".equalsIgnoreCase(shape)){
			return new Square();
		}
		return null;
	}

}
