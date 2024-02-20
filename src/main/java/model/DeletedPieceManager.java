package model;

import java.util.HashSet;
import java.util.Set;

public class DeletedPieceManager implements IDeletedPieceManager {

    // DELETED PIECE MANAGER ATTRIBUTES
    private Set<Piece> pieces;

    // BUILDER
    public DeletedPieceManager() { pieces = new HashSet<>(); }

    // ADD PIECE METHOD
    @Override
    public void addPiece (Piece piece) {
        pieces.add(piece);
    }

    // COUNT METHOD
    public int count (Piece.Type type){
        return pieces.size();
    }

    // GET METHOD
    public Piece get (int index) { return (Piece) pieces.toArray()[index]; }

    // REMOVE LAST METHOD
    public Piece removeLast() {
        Piece piece = get(0);
        pieces.remove(piece);
        return piece;
    }

    // TO STRING METHOD
    @Override
    public String toString() {

        return pieces.toString();
    }

}