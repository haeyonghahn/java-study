package paint;

import chapter03.Global;

// Java에서는 global을 지원안해준다. C++ 등에서는 지원해주는데. 그래서 나온 것이 static
//int globalVar = 100;
//void globalFunc() {
//	System.out.println("Hello world");
//}

public class PaintApp {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point point1 = new Point();
		point1.setX(2);
		point1.setY(5);
	
		Shape rect = new Rect();
		drawShape(rect);
		
		Shape triangle = new Triangle();
		drawShape(triangle);
		
		Circle circle = new Circle();
		drawShape(circle);
		
		GraphicTest gt = new GraphicTest("hello");
		gt.draw();
	}

	public static void draw(Drawable draw) {
		draw.draw();
	}
	
	public static void drawShape(Shape shape) {
		shape.draw();
	}
	
	public static void globalTest() {
		System.out.println(Global.globalVar);
	}
}
