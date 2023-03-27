package decorator.pizza;

public class CapsicumPizza implements Pizza{

    @Override
    public int getPrice() {
        return 100;
    }

    @Override
    public String type() {
        return "capsicum";
    }
}
