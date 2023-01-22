package liskov_sustitution_priniciple;

public class AritmeticsPowered extends Aritmetic{
    @Override
    public int sustract(int a, int b){
        return a - b;
    }
    @Override
    public int power(int a, int b){
        return a ^ b;
    }
    @Override
    public int addTo(int a, int b) {
        return a + b;
    }
    @Override
    public int multiplication(int a, int b) {
        return a * b;
    }
    @Override
    public int divition(int a, int b) {
        return a / b;
    }
}

