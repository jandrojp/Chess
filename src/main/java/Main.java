public class Main {
    public static void main(String[] args) {
        Board b1 = new Board();

        Knight k1 = new Knight(b1, new Coordinate('A', 3), Knight.Type.BLACK);
        b1.highlight(k1.getNextMovements());
        System.out.println(b1);
    }
}
