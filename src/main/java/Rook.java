public class Rook extends Piece {
    public Rook(Board board, Coordinate position, Type type) {
        super(type.getType(), board.getCellAt(position));
    }

    public enum Type {
        BLACK(Piece.Type.BLACK_ROOK),
        WHITE(Piece.Type.WHITE_ROOK);

        private Piece.Type type;

        Type(Piece.Type type) {
            this.type = type;
        }

        public Piece.Type getType() {
            return type;
        }
    }

}
