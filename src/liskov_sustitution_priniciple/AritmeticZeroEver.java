package liskov_sustitution_priniciple;

public class AritmeticZeroEver extends Aritmetic{
    @Override
    public int addTo(int a, int b) {
        return 0;
    }

    @Override
    public int sustract(int a, int b) {
        return 0;
    }

    @Override
    public int multiplication(int a, int b) {
        return 0;
    }

    @Override
    public int divition(int a, int b) {
        return 0;
    }

    @Override
    public int power(int a, int b) {
        return 0;
    }
}
