package designpatterns;

public class StrategyDesignPattern {

    public static void main(String[] args) {
        Context c = new Context(new AddStrategy());
        System.out.println(c.performAction(12,10));
    }
}

interface  Strategy{
    public int calculate(int a, int b);
}

class AddStrategy implements Strategy{
    @Override
    public int calculate(int a, int b) {
        return a+b;
    }
}

class SubStrategy implements Strategy{
    @Override
    public int calculate(int a, int b) {
        return a-b;
    }
}

class Context{
    private Strategy s;
    Context(Strategy s){
        this.s = s;
    }
    public int performAction(int a , int b){
        return s.calculate(a, b);
    }
}