public class Knight extends Piece {

    public Knight(Board board, Coordinate position, Type type) {
        super(type.getType(), board.getCellAt(position));
    }


    public enum Type {
        BLACK(Piece.Type.BLACK_KNIGHT), WHITE(Piece.Type.WHITE_KNIGHT);
        private Piece.Type type;

        Type(Piece.Type type) {
            this.type = type;
        }

        public Piece.Type getType() {
            return type;
        }
    }
}