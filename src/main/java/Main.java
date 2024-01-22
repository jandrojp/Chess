public class Main {
    public static void main(String[] args) {
        Board b1 = new Board();

        Knight k1 = new Knight(b1, new Coordinate('D', 4), Knight.Type.BLACK);
        Pawn p1 = new Pawn(b1, new Coordinate('C', 2), Pawn.Type.WHITE);

        b1.highlight(k1.getNextMovements());
        System.out.println(b1);

        b1.resetColor();
        System.out.println(b1);
    }
}
