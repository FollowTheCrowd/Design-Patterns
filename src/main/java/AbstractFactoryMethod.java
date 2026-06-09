/**
 * 功能
 * 作者：八滴水
 * 日期： 2026/6/8 00:44
 */
// 抽象产品接口: 操作系统
interface OperatingSystem{
    void run();
}

//具体产品：windows和Linux
class WindowOperatingSystem implements OperatingSystem{
    @Override
    public void run() {
        System.out.println("Running Window Operating System ");
    }
}

class LinuxOperatingSystem implements OperatingSystem{
    @Override
    public void run() {
        System.out.println("Running Linux Operating System ");
    }
}

//抽象产品接口 ：  应用程序
interface Application{
    void open();
}

//具体产品：word和excel
class WordApplication implements Application{
    @Override
    public void open() {
        System.out.println("Opening Word Application ");
    }
}

class ExcelApplication implements Application{
    @Override
    public void open(){
        System.out.println("Opening Excel Application ");
    }
}

//抽象工厂接口
interface SoftwareApplication{
    OperatingSystem createOperatingSystem();
    Application createApplication();
}

class WindowsFactory implements SoftwareApplication{
    @Override
    public OperatingSystem createOperatingSystem() {
        return new WindowOperatingSystem();
    }
    @Override
    public Application createApplication() {
        return new WordApplication();
    }
}

class LinuxFactory implements SoftwareApplication{
    @Override
    public OperatingSystem createOperatingSystem() {
        return new LinuxOperatingSystem();
    }
    @Override
    public Application createApplication() {
        return new ExcelApplication();
    }
}

public class AbstractFactoryMethod {
    public static void main(String[] args) {
        SoftwareApplication WindowsFactory = new WindowsFactory();
        OperatingSystem windowsOS = WindowsFactory.createOperatingSystem();
        Application windowsApp = WindowsFactory.createApplication();
        windowsOS.run();
        windowsApp.open();

        SoftwareApplication LinuxFactory = new LinuxFactory();
        OperatingSystem linuxOS = LinuxFactory.createOperatingSystem();
        Application linuxApp = LinuxFactory.createApplication();
        linuxOS.run();
        linuxApp.open();
    }
}
