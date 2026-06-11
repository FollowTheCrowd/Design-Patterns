/**
 * 功能
 * 作者：八滴水
 * 日期： 2026/6/11 19:56
 */

//表示数接口
interface Expression {
    int display();
}

//表示数实现
class NumberExpression implements Expression {
    private int num;
    public NumberExpression(int num) {
        this.num = num;
    }
    public int display() {
        return num;
    }
}

//加法表达式
class AdditionExpression implements Expression {
    private Expression left;
    private Expression right;
    public AdditionExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
    public int display() {
        return left.display() + right.display();
    }
}
//减法表达式
 class SubtractionExpression implements Expression {
    private Expression left;
    private Expression right;
    public SubtractionExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
    public int display() {
        return left.display() - right.display();
    }
}
//做个表达式1+(6-5)
public class InterpreterMethod {
    public static void main(String[] args) {
        Expression ans = new AdditionExpression(
                new NumberExpression(1),
                new SubtractionExpression(
                        new NumberExpression(6),
                        new NumberExpression(5)
                )
        );
        int ansDisplay = ans.display();
        System.out.println(ansDisplay);

    }
}
