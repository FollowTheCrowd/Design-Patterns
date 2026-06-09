/**
 * 功能
 * 作者：八滴水
 * 日期： 2026/6/8 15:41
 */

//已存在的LegacyRectangle类
class LegacyRectangle{
    void display(int x1,int y1,int x2,int y2){
        System.out.println(x1+","+y1+","+x2+","+y2);
    }
}

//统一的Shape
class Shape2{
    void draw(int x,int y,int width,int height){
    }
}

//适配器类RectangleAdapter
class RectangleAdapter extends Shape2{
    private LegacyRectangle rectangle;

    public RectangleAdapter(LegacyRectangle rectangle){
        this.rectangle = rectangle;
    }

    @Override
    public void draw(int x,int y,int width,int height){
        int x1 = x;
        int y1 = y;
        int x2 = x + width;
        int y2 = y + height;
        rectangle.display(x1,y1,x2,y2);
    }
}

public class AdapterMethod {
    public static void main(String[] args) {
        LegacyRectangle rectangle = new LegacyRectangle();
        RectangleAdapter rectangleAdapter = new RectangleAdapter(rectangle);
        rectangleAdapter.draw(10,20,30,40);

    }
}
