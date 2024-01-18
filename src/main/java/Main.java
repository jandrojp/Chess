public class Main {
    public static void main(String[] args) {
        Board b1 = new Board();

        King k1 = new King(b1, new Coordinate('A', 3), King.Type.BLACK);
        System.out.println(b1);
    }
}
