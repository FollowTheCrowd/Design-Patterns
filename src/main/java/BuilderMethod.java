import lombok.Setter;
import lombok.ToString;

/**
 * 功能
 * 作者：八滴水
 * 日期： 2026/6/8 01:07
 */
//首先定义房屋类House，有地基，结构，屋顶，内饰四个属性 。
@Setter
@ToString
class House{
    private String foundation;
    private String structure;
    private String roof;
    private String interior;
}

//创建一个抽象类建造者HouseBuilder，定义构造房屋的方法 。
abstract class HouseBuilder{
    protected House house = new House();

    public abstract void buildFoundation();
    public abstract void buildStructure();
    public abstract void buildRoof();
    public abstract void buildInterior();

    public House getHouse(){
        return house;
    }
}

//接下来创建两个建造者类，ConcreteHouseBuilder和LuxuryHouseBuilder
//实现不同类型房屋的构造
class ConcreteHouseBuilder extends HouseBuilder{
    @Override
    public void buildFoundation() {
        house.setFoundation("Standard Foundation");
    }

    @Override
    public void buildStructure() {
        house.setStructure("Standard Structure");
    }

    @Override
    public void buildRoof() {
        house.setRoof("Standard Roof");
    }

    @Override
    public void buildInterior() {
        house.setInterior("Standard Interior");
    }
}

class LuxuryHouseBuilder extends HouseBuilder{
    @Override
    public void buildFoundation() {
        house.setFoundation("Strong Foundation");
    }

    @Override
    public void buildStructure() {
        house.setStructure("Reinforced Structure");//Reinforced:强化的
    }

    @Override
    public void buildRoof() {
        house.setRoof("Elegant Roof");
    }

    @Override
    public void buildInterior() {
        house.setInterior("Luxury Interior");
    }
}

//最后创建指导者类 Director，它来协调建造过程并返回构建的房子对象。
class Director{
    private HouseBuilder builder;

    public Director(HouseBuilder builder){
        this.builder = builder;
    }
    public House constructHouse(){
        builder.buildFoundation();
        builder.buildStructure();
        builder.buildRoof();
        builder.buildInterior();
        return builder.getHouse();
    }
}

public class BuilderMethod {
    public static void main(String[] args) {
        HouseBuilder concreteBuilder = new ConcreteHouseBuilder();
        Director director = new Director(concreteBuilder);
        House concreteHouse = director.constructHouse();
        System.out.println(concreteHouse);

        HouseBuilder luxuryBuilder = new LuxuryHouseBuilder();
        Director director1 = new Director(luxuryBuilder);
        House luxuryHouse = director1.constructHouse();
        System.out.println(luxuryHouse);
    }
}
