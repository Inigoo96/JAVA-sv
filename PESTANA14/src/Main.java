public class Main {
    public static void main(String[] args) {
        int a = 5;
        int b = 5;
        int c = 8;

        a = b++ + ++c;

        System.out.println("La suma de " + (b+1) + " + " + (c+1) + " es igual a " + a);
    }
}
