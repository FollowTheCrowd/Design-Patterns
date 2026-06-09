/**
 * 功能
 * 作者：八滴水
 * 日期： 2026/6/8 23:27
 */
//颜色接口
interface Color{
    void applyColor();
}

class Yellow implements Color{
    @Override
    public void applyColor() {
        System.out.println("Yellow");
    }
}
class Green implements Color{
    @Override
    public void applyColor() {
        System.out.println("Green");
    }
}

//抽象类
abstract class Shape3{
    protected Color color;

    public Shape3(Color color){
        this.color = color;
    }

    abstract void draw();
}

class Circle1 extends Shape3{
    public Circle1(Color color){
        super(color);
    }

    @Override
    void draw() {
        System.out.println("Circle1");
        color.applyColor();
    }
}

class Square extends Shape3{
    public Square(Color color){
        super(color);
    }

    @Override
    void draw() {
        System.out.println("Square");
        color.applyColor();
    }
}

public class BridgeMethod {
    public static void main(String[] args) {
        Color yellow = new Yellow();
        Color green = new Green();
        Shape3 circle1 = new Circle1(yellow);
        Shape3 square = new Square(green);
        circle1.draw();
        square.draw();
    }
}
