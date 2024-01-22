public class Main {
    public static void main(String[] args) {
        Board b1 = new Board();

        Queen bishop = new Queen(b1, new Coordinate('D', 4), Queen.Type.BLACK);

        b1.highlight(bishop.getNextMovements());

        System.out.println(b1);
        b1.resetColor();
        System.out.println(b1);
    }
}
