package model;

import java.util.HashSet;
import java.util.Set;

import static com.diogonunes.jcolor.Ansi.colorize;

public class RemainingPieceManager implements IDeletedPieceManager {
    // DELETED PIECE MANAGER ATTRIBUTES
    private Set<Piece> pieces;

    // BUILDER
    public RemainingPieceManager() { pieces = new HashSet<>(); }

    // ADD PIECE METHOD
    @Override
    public void addPiece (Piece piece) {
        pieces.add(piece);
    }

    // COUNT METHOD
    public int count (Piece.Type type){
        return (int) pieces.stream().filter(p -> p.getType().equals(type)).count();
    }

    // GET METHOD
    public Piece get (int index) { return (Piece) pieces.toArray()[index]; }

    // REMOVE LAST METHOD
    public void removeLast(Piece piece) {
        pieces.remove(piece);
    }

    // TO STRING METHOD
    @Override
    public String toString() {
        String output = "                                                                 ";

        if (pieces != null) {
            for (Piece.Type type : Piece.Type.values()) {
                output += colorize(" " + type.getShape() + " ", type.getColor().getAttribute(), Cell.Color.GREEN.getAttribute());
            }

            output += "\n                                                                 ";

            for (Piece.Type type : Piece.Type.values()) {
                output += colorize(" " + count(type) + " ", type.getColor().getAttribute(), Cell.Color.WHITE.getAttribute());
            }
        }

        return output;
    }
}
