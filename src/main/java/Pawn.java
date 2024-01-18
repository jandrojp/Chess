public class Pawn extends Piece {

    public Pawn(Board board, Coordinate position, Type type) {
        super(type.getType(), board.getCellAt(position));
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
