/**
 * 功能
 * 作者：八滴水
 * 日期： 2026/6/11 23:36
 */
//模板类
abstract class AbstractClass {
    //模板方法，定义算法骨架
    public void templateMethod() {
        step1();
        step2();
        step3();
    }
    //基本方法 ，子类实现
    abstract void step1();
    abstract void step2();
    abstract void step3();
}
//具体子类实现.
class ConcreteClass extends AbstractClass {
    @Override
    void step1() {
        System.out.println("step1");
    }

    @Override
    void step2() {
        System.out.println("step2");
    }

    @Override
    void step3() {
        System.out.println("step3");
    }
}

public class TemplateMethod {
    public static void main(String[] args) {
        AbstractClass abstractClass = new ConcreteClass();
        abstractClass.templateMethod();


    }
}
