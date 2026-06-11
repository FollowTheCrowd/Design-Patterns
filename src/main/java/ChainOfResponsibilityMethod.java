/**
 * 功能
 * 作者：八滴水
 * 日期： 2026/6/12 00:15
 */
//表示请求的接口Request
class ChainRequest{
    private double amount;
    private String description;
    public ChainRequest(double amount, String description){
        this.amount = amount;
        this.description = description;
    }
    public double getAmount(){
        return amount;
    }
    public String getDescription(){
        return description;
    }

}
//创建一个抽象处理者类
abstract class ChainRequestHandler{
    protected ChainRequestHandler successor;

    public abstract void handleRequest(ChainRequest request);

    public void setSuccessor(ChainRequestHandler successor) {
        this.successor = successor;
    }
}
//接下来做一个具体处理者类 ：经理，部门主管，财务部门主管
class ManagerHandler extends ChainRequestHandler{
    @Override
    public void handleRequest(ChainRequest request) {
        if(request.getAmount() <= 1000){
            System.out.println("Manager can deal with" + request.getAmount() + "用来" + request.getDescription());
        }else if(successor != null){
            successor.handleRequest(request);
        }
    }

}

class DepartmentHandler extends ChainRequestHandler{
    @Override
    public void handleRequest(ChainRequest request) {
        if(request.getAmount() <= 5000){
            System.out.println("Department can deal with" + request.getAmount()+ "用来" + request.getDescription());
        }else if(successor != null){
            successor.handleRequest(request);
        }
    }
}

class FinanceHandler extends ChainRequestHandler{
    @Override
    public void handleRequest(ChainRequest request) {
        System.out.println("Finance can deal with" + request.getAmount()+ "用来" + request.getDescription());
    }
}

public class ChainOfResponsibilityMethod {
    public static void main(String[] args) {
        ChainRequestHandler managerHandler = new ManagerHandler();
        ChainRequestHandler departmentHandler = new DepartmentHandler();
        ChainRequestHandler financeHandler = new FinanceHandler();
        managerHandler.setSuccessor(departmentHandler);
        departmentHandler.setSuccessor(financeHandler);
        managerHandler.handleRequest(new ChainRequest(4000, "发奖金"));
        managerHandler.handleRequest(new ChainRequest(1000000000,"回购买股份"));
        managerHandler.handleRequest(new ChainRequest(100,"买香烟"));

    }
}
