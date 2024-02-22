package model;

import java.util.*;

public class Board {

    private final Map<Coordinate, Cell> cells;
    private RemainingPieceManager remainingPieces;
    private DeletedPieceManager deletedPieces;

    public Board() {
        cells = new HashMap<>();
        remainingPieces = new RemainingPieceManager();
        deletedPieces = new DeletedPieceManager();
        initializeCells();
    }

    private void initializeCells() {
        Coordinate coordinate;
        Cell cell;

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                coordinate = new Coordinate((char) ('A' + col), 1 + row);
                cell = new Cell(this, coordinate);
                cells.put(coordinate, cell);
            }
        }
    }

    public void placePieces() {

        King kingBlack = new King(this, new Coordinate('E', 1), King.Type.BLACK);
        remainingPieces.addPiece(kingBlack);
        King kingWhite = new King(this, new Coordinate('E', 8), King.Type.WHITE);
        remainingPieces.addPiece(kingWhite);

        Queen queenBlack = new Queen(this, new Coordinate('D', 1), Queen.Type.BLACK);
        remainingPieces.addPiece(queenBlack);
        Queen queenWhite = new Queen(this, new Coordinate('D', 8), Queen.Type.WHITE);
        remainingPieces.addPiece(queenWhite);

        Bishop bishopBlack1 = new Bishop(this, new Coordinate('C', 1), Bishop.Type.BLACK);
        remainingPieces.addPiece(bishopBlack1);
        Bishop bishopBlack2 = new Bishop(this, new Coordinate('F', 1), Bishop.Type.BLACK);
        remainingPieces.addPiece(bishopBlack2);
        Bishop bishopWhite1 = new Bishop(this, new Coordinate('C', 8), Bishop.Type.WHITE);
        remainingPieces.addPiece(bishopWhite1);
        Bishop bishopWhite2 = new Bishop(this, new Coordinate('F', 8), Bishop.Type.WHITE);
        remainingPieces.addPiece(bishopWhite2);

        Knight knightBlack1 = new Knight(this, new Coordinate('B', 1), Knight.Type.BLACK);
        remainingPieces.addPiece(knightBlack1);
        Knight knightBlack2 = new Knight(this, new Coordinate('G', 1), Knight.Type.BLACK);
        remainingPieces.addPiece(knightBlack2);
        Knight knightWhite1 = new Knight(this, new Coordinate('B', 8), Knight.Type.WHITE);
        remainingPieces.addPiece(knightWhite1);
        Knight knightWhite2 = new Knight(this, new Coordinate('G', 8), Knight.Type.WHITE);
        remainingPieces.addPiece(knightWhite2);

        Rook rookBlack1 = new Rook(this, new Coordinate('A', 1), Rook.Type.BLACK);
        remainingPieces.addPiece(rookBlack1);
        Rook rookBlack2 = new Rook(this, new Coordinate('H', 1), Rook.Type.BLACK);
        remainingPieces.addPiece(rookBlack2);
        Rook rookWhite1 = new Rook(this, new Coordinate('A', 8), Rook.Type.WHITE);
        remainingPieces.addPiece(rookWhite1);
        Rook rookWhite2 = new Rook(this, new Coordinate('H', 8), Rook.Type.WHITE);
        remainingPieces.addPiece(rookWhite2);

        for (int col = 0; col < 8; col++) {
            Pawn pawnBlack = new Pawn(this, new Coordinate((char) ('A' + col), 2), Pawn.Type.BLACK);
            remainingPieces.addPiece(pawnBlack);
            Pawn pawnWhite = new Pawn(this, new Coordinate((char) ('A' + col), 7), Pawn.Type.WHITE);
            remainingPieces.addPiece(pawnWhite);
        }
    }

    public boolean contains(Coordinate c) {
        return !(c.getNumber() < 1 || c.getNumber() > 8 || c.getLetter() < 'A' || c.getLetter() > 'H');
    }

    public Cell getCellAt(Coordinate c) {
        if (!contains(c)) return null;
        return cells.get(c);
    }
    public RemainingPieceManager getRemainingPieces() { return remainingPieces; }
    public DeletedPieceManager getDeletedPieces() { return deletedPieces; }

    public void highlight(Set<Coordinate> coordinates) {
        for (Coordinate c : coordinates)
            cells.get(c).highlight();
    }

    public void resetColor() {
        for (Coordinate c : cells.keySet())
            cells.get(c).resetColor();
    }

}