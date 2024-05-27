package objects;

public class Type {
    private Type() {

    }

    private static int a = 5;

    private static Type instance;


    public static Type getInstance() {
        if (instance == null) {
            instance = new Type();
        }
        return instance;
    }

    public int getA() {
        return a;
    }

    public void setA(int b) {
        a = b;
    }
}
