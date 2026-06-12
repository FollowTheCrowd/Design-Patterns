/**
 * 功能
 * 作者：八滴水
 * 日期： 2026/6/12 09:15
 */
//命令接口
interface command{
    void execute();
}
//具体命令：控制开灯
class LightOnCommand implements command{
    private Light light;
    public LightOnCommand(Light light){
        this.light = light;
    }
    public void execute(){
        light.turnOn();
    }
}
//控制关灯
class LightOffCommand implements command{
    private Light light;
    public LightOffCommand(Light light){
        this.light = light;
    }
    public void execute(){
        light.turnOff();
    }
}

class Light{
    void turnOn(){
        System.out.println("Light on");
    }
    void turnOff(){
        System.out.println("Light off");
    }
}

//遥控类
class Remote{
    private command command;
    public void setCommand(command command){
        this.command = command;
    }

    public void execute(){
        command.execute();
    }
}
public class CommandMethod {
    public static void main(String[] args) {
        Light light = new Light();

        LightOnCommand lightOnCommand = new LightOnCommand(light);
        LightOffCommand lightOffCommand = new LightOffCommand(light);
        Remote remote = new Remote();
        remote.setCommand(lightOnCommand);
        remote.execute();//开灯
        remote.setCommand(lightOffCommand);
        remote.execute();//关灯




    }
}
