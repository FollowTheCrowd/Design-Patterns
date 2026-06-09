/**
 * 功能
 * 作者：八滴水
 * 日期： 2026/6/8 01:50
 */

//创建一个实现Cloneable接口的原型类
class Shape1 implements Cloneable{
    private String type;

    public Shape1(String type){
        this.type = type;
    }
    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type = type;
    }

    @Override
    public Shape1 clone(){
        try{
            return (Shape1) super.clone();
        }catch(CloneNotSupportedException e){
            return null;
        }
    }

}

//测试原型模型
public class PrototypeMethod {
    public static void main(String[] args) {
        //创建原型对象
        Shape1 circle = new Shape1("Circle");

        //克隆原型对象来创建新对象
        Shape1 clonedCircle = circle.clone();
        clonedCircle.setType("Cloned Circle");

        //输出原型对象和克隆对象的类型
        System.out.println(circle.getType());
        System.out.println(clonedCircle.getType());


    }
}
