import java.util.HashMap;
import java.util.Map;
import java.awt.Color;
/**
 * 功能
 * 作者：八滴水
 * 日期： 2026/6/10 01:15
 */

//享元接口
interface Shape4{
    void draw(int x,int y);
}

//具体享元类
class Circle2 implements Shape4{
    private Color color;

    public Circle2(Color color){
        this.color = color;
    }
    @Override
    public void draw(int x,int y){
        System.out.println("Circle" + color + "draw (" + x + ", " + y + ")");
    }
}

//享元工厂类
class ShapeFactory {
    private static final Map<Color,Shape4> circleMap = new HashMap<Color,Shape4>();

    public static Shape4 getCircle(Color color){
        Shape4 shape = circleMap.get(color);
        if(shape == null){
            shape = new Circle2(color);
            circleMap.put(color, shape);
        }
        return shape;
    }

}

public class FlyweightMethod {
    public static void main(String[] args) {
        Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW};

        for(int i=0; i<20; i++){
            Color randomColor = colors[(int)(Math.random()*colors.length)];
            Shape4 circle = ShapeFactory.getCircle(randomColor);
            circle.draw((int)(Math.random()*100), (int)(Math.random()*100));
        }


    }
}
