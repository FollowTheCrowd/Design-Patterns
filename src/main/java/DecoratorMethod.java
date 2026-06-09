/**
 * 功能
 * 作者：八滴水
 * 日期： 2026/6/9 00:22
 */
//定义一个咖啡接口
interface Coffee{
    double price();
    String description();
}
//基本咖啡类
class SimpleCoffee implements Coffee{
    @Override
    public double price() {
        return 1.5;
    }

    @Override
    public String description() {
        return "Simple Coffee";
    }

}

//装饰器类
abstract class CoffeeDecorator implements Coffee{
    protected Coffee coffee;
    public CoffeeDecorator(Coffee coffee){
        this.coffee = coffee;
    }
    @Override
    public double price() {
        return coffee.price();
    }
    @Override
    public String description() {
        return coffee.description();
    }
}

//实现具体装饰类
class MilkCoffee extends CoffeeDecorator{
    public MilkCoffee(Coffee coffee){
        super(coffee);
    }
    @Override
    public double price() {
        return coffee.price() + 0.5;
    }
    @Override
    public String description() {
        return coffee.description() + "With Milk";
    }
}

class SugarCoffee extends CoffeeDecorator{
    public SugarCoffee(Coffee coffee){
        super(coffee);
    }
    @Override
    public double price() {
        return coffee.price() + 1.5;
    }
    @Override
    public String description() {
        return coffee.description() + "With Sugar";
    }
}

public class DecoratorMethod {
    public static void main(String[] args) {
        Coffee simpleCoffee = new SimpleCoffee();
        System.out.println("Cost: $"+ simpleCoffee.price() + "," + simpleCoffee.description());

        Coffee milkCoffee = new MilkCoffee(simpleCoffee);
        System.out.println("Cost: $"+ milkCoffee.price() + "," + milkCoffee.description());

        Coffee sugarCoffee = new SugarCoffee(milkCoffee);
        System.out.println("Cost: $"+ sugarCoffee.price() + "," + sugarCoffee.description());
    }
}
