package model;


public interface IDeletedPieceManager {

    // ADD PIECE METHOD
    void addPiece (Piece piece);

    // COUNT METHOD
    int count (Piece.Type pieceType);

    // REMOVE LAST METHOD
    void removeLast (Piece piece);
}
