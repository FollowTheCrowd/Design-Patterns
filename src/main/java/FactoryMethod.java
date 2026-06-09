/**
 * 功能
 * 作者：八滴水
 * 日期： 2026/6/8 00:01
 */
interface Shape{
    void draw();
}

class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}
class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("Drawing a rectangle");
    }
}
// 创建一个抽象工厂类Factory，里面定义了一个抽象方法，子类将负责实现具体方法
abstract class Factory{
    abstract Shape create();
}

class CircleFactory extends Factory{
    @Override
    Shape create() {
        return new Circle();
    }
}

class RectangleFactory extends Factory{
    @Override
    Shape create() {
        return new Rectangle();
    }
}

public class FactoryMethod {
    public static void main(String[] args) {
        Factory CirFactory = new CircleFactory();
        Shape Cir = CirFactory.create();
        Cir.draw();

        Factory RectFactory = new RectangleFactory();
        Shape Rect = RectFactory.create();
        Rect.draw();

    }
}
