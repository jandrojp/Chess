package model;

import java.util.HashSet;
import java.util.Set;

public class Pawn extends Piece {

    public Pawn(Board board, Coordinate position, Type type) {
        super(type.getType(), board.getCellAt(position));
    }

    @Override
    public Set<Coordinate> getNextMovements() {
        if (getColor() == Color.BLACK)
            return getNextMovementsAsBlack();
        else
            return getNextMovementsAsWhite();
    }

    private Set<Coordinate> getNextMovementsAsWhite() {
        Set<Coordinate> posicionesCandidatas = new HashSet<>();
        Coordinate c;
        Coordinate position = getCell().getCoordinate();
        Board board = getCell().getBoard();

        // posicion delante
        c = position.up();
        if (board.contains(c) && board.getCellAt(c).getPiece() == null)
            posicionesCandidatas.add(c);

        // avanza matando
        c = position.diagonalUpLeft();
        if (board.contains(c)
                && (board.getCellAt(c).getPiece() != null && board.getCellAt(c).getPiece().getColor() != getColor()))
            posicionesCandidatas.add(c);

        c = position.diagonalUpRight();
        if (board.contains(c)
                && (board.getCellAt(c).getPiece() != null && board.getCellAt(c).getPiece().getColor() != getColor()))
            posicionesCandidatas.add(c);

        // Si esta en la posicion inicial se le permite avanzar 2 posiciones
        if (position.getNumber() == 7) {
            c = position.up();
            if (board.contains(c) && board.getCellAt(c).getPiece() == null) {
                c = c.up();
                if (board.contains(c) && board.getCellAt(c).getPiece() == null) {
                    posicionesCandidatas.add(c);
                }
            }
        }
        return posicionesCandidatas;
    }

    private Set<Coordinate> getNextMovementsAsBlack() {
        Set<Coordinate> posicionesCandidatas = new HashSet<>();
        Coordinate c;
        Coordinate position = getCell().getCoordinate();
        Board board = getCell().getBoard();

        // posicion delante
        c = position.down();
        if (board.contains(c) && board.getCellAt(c).getPiece() == null)
            posicionesCandidatas.add(c);

        // avanza matando
        c = position.diagonalDownLeft();
        if (board.contains(c)
                && (board.getCellAt(c).getPiece() != null && board.getCellAt(c).getPiece().getColor() != getColor()))
            posicionesCandidatas.add(c);

        c = position.diagonalDownRight();
        if (board.contains(c)
                && (board.getCellAt(c).getPiece() != null && board.getCellAt(c).getPiece().getColor() != getColor()))
            posicionesCandidatas.add(c);

        // Si esta en la posicion inicial se le permite avanzar 2 posiciones
        if (position.getNumber() == 2) {
            c = position.down();
            if (board.contains(c) && board.getCellAt(c).getPiece() == null) {
                c = c.down();
                if (board.contains(c) && board.getCellAt(c).getPiece() == null) {
                    posicionesCandidatas.add(c);
                }
            }
        }
        return posicionesCandidatas;
    }

    @Override
    public boolean moveTo(Coordinate coordinate) {

        if (!super.moveTo(coordinate)) return false;

        if (getCell().getCoordinate().getNumber() == 1 || getCell().getCoordinate().getNumber() == 8) {
            Cell cell = getCell();
            remove();

            if (getColor() == Color.BLACK) {
                new Queen(cell.getBoard(), coordinate, Queen.Type.BLACK);
            } else {
                new Queen(cell.getBoard(), coordinate, Queen.Type.WHITE);
            }
        }

        return true;
    }

    public enum Type {
        BLACK(Piece.Type.BLACK_PAWN),
        WHITE(Piece.Type.WHITE_PAWN);

        private Piece.Type type;

        Type(Piece.Type type) {
            this.type = type;
        }

        public Piece.Type getType() {
            return type;
        }
    }
}
