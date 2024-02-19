package model;

import java.util.HashSet;
import java.util.Set;

public class King extends Piece {

    public King(Board board, Coordinate position, Type type) {
        super(type.getType(), board.getCellAt(position));
    }

    @Override
    public Set<Coordinate> getNextMovements() {

        Set<Coordinate> nextMovements = new HashSet<>();
        Coordinate myPosition = getCell().getCoordinate();
        Coordinate c;

        // Up
        c = myPosition.up();
        if (canAddToNextMovements(c)) nextMovements.add(c);

        // Down
        c = myPosition.down();
        if (canAddToNextMovements(c)) nextMovements.add(c);

        // Left
        c = myPosition.left();
        if (canAddToNextMovements(c)) nextMovements.add(c);

        // Right
        c = myPosition.right();
        if (canAddToNextMovements(c)) nextMovements.add(c);

        // Up Left
        c = myPosition.diagonalUpLeft();
        if (canAddToNextMovements(c)) nextMovements.add(c);

        // Up right
        c = myPosition.diagonalUpRight();
        if (canAddToNextMovements(c)) nextMovements.add(c);

        // Down Left
        c = myPosition.diagonalDownLeft();
        if (canAddToNextMovements(c)) nextMovements.add(c);

        // Down Right
        c = myPosition.diagonalDownRight();
        if (canAddToNextMovements(c)) nextMovements.add(c);

        return nextMovements;
    }

    public enum Type {
        BLACK(Piece.Type.BLACK_KING),
        WHITE(Piece.Type.WHITE_KING);

        private Piece.Type type;

        Type(Piece.Type type) {
            this.type = type;
        }

        public Piece.Type getType() {
            return type;
        }
    }
}
