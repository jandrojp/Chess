package model;

import com.diogonunes.jcolor.Attribute;

import java.util.Set;

import static com.diogonunes.jcolor.Ansi.colorize;

public abstract class Piece {
    private Type type;
    private Cell cell;

    public Piece(Type type, Cell cell){
        this.type = type;
        this.cell = cell;
        placePiece();
    }

    protected void placePiece() {
        if (cell != null)
            cell.setPiece(this);
    }
    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public Type getType() {
        return type;
    }

    public Cell getCell() {
        return cell;
    }

    public Color getColor(){
        return type.getColor();
    }

    protected boolean canAddToNextMovements(Coordinate coordinate) {

        Board b1 = getCell().getBoard();

        if (!b1.contains(coordinate))  return false;

        if (b1.getCellAt(coordinate).isEmpty()) return true;

        if (b1.getCellAt(coordinate).getPiece().getColor() != getColor()) return true;

        return false;
    }

    public abstract Set<Coordinate> getNextMovements();

    public boolean canMoveTo(Coordinate coordinate) {

        for (Coordinate c : getNextMovements()) {
            if (coordinate.equals(c)) {
                return true;
            }
        }

        return false;
    }

    public void remove(){

        if (cell != null)
            cell.setPiece(null);

        cell = null;
    }

    public boolean moveTo(Coordinate coordinate) {

        /*
        if (!canMoveTo(coordinate))
            return false;

         */

        Board board = cell.getBoard();

        if (!board.getCellAt(coordinate).isEmpty()) {
            board.getCellAt(coordinate).getPiece().remove();

            Piece p = board.getCellAt(coordinate).getPiece();
            board.getDeletedPieces().addPiece(p);
        }

        remove();
        setCell(board.getCellAt(coordinate));
        placePiece();

        return true;
    }

    @Override
    public String toString() {
        if (cell == null)
            return colorize(type.getShape(), type.getColor().getAttribute());
        return colorize(type.getShape(),type.getColor().getAttribute(),cell.getColor().getAttribute());
    }

    public enum Color {
        WHITE(Attribute.TEXT_COLOR(255,255,255)),
        BLACK(Attribute.TEXT_COLOR(0,0,0));

        private final Attribute color;
        Color(Attribute color){
            this.color=color;
        }

        public Attribute getAttribute() {
            return color;
        }
    }

    public enum Type {
        WHITE_KING("\u265A", Color.WHITE),
        WHITE_QUEEN("\u265B", Color.WHITE),
        WHITE_ROOK("\u265C", Color.WHITE),
        WHITE_BISHOP("\u265D", Color.WHITE),
        WHITE_KNIGHT("\u265E", Color.WHITE),
        WHITE_PAWN("\u265F", Color.WHITE),
        BLACK_KING("♚", Color.BLACK),
        BLACK_QUEEN("♛", Color.BLACK),
        BLACK_ROOK("♜", Color.BLACK),
        BLACK_BISHOP("♝", Color.BLACK),
        BLACK_KNIGHT("♞", Color.BLACK),
        BLACK_PAWN("♟", Color.BLACK);

        private final String shape;
        private final Color color;

        Type(String shape, Color color){
            this.shape=shape;
            this.color=color;
        }

        public Color getColor() {
            return color;
        }

        public String getShape() {
            return shape;
        }
    }

}
