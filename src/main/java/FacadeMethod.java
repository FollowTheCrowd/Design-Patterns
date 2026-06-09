/**
 * 功能
 * 作者：八滴水
 * 日期： 2026/6/9 00:54
 */
//子系统：音响
class StereoSystem{
    public void turnOn(){
        System.out.println("Stereo System is on");
    }
    public void turnOff(){
        System.out.println("Stereo System is off");
    }
}

//子系统: 投影仪
class Projector{
    public void turnOn(){
        System.out.println("Projector is on");
    }
    public void turnOff(){
        System.out.println("Projector is off");
    }
}

//子系统: 灯光
class LightsControl{
    public void turnOn(){
        System.out.println("Lights Control is on");
    }
    public void turnOff(){
        System.out.println("Lights Control is off");
    }
}

//外观类:负责家庭影院外观组合
class  HomeTheaterFacade{
    private StereoSystem stereoSystem;
    private Projector projector;
    private LightsControl lightsControl;

    public HomeTheaterFacade(){
        stereoSystem = new StereoSystem();
        projector = new Projector();
        lightsControl = new LightsControl();
    }

    //关灯开电影
    public void watchMovie(){
        lightsControl.turnOff();
        stereoSystem.turnOn();
        projector.turnOn();
    }

    //开灯关电影
    public void turnOffMovie(){
        lightsControl.turnOn();
        stereoSystem.turnOff();
        projector.turnOff();
    }
}


public class FacadeMethod {
    public static void main(String[] args) {
        HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade();
        homeTheaterFacade.watchMovie();
        homeTheaterFacade.turnOffMovie();


    }
}
