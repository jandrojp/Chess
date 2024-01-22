public class King extends Piece {

    public King(Board board, Coordinate position, Type type) {
        super(type.getType(), board.getCellAt(position));
    }

    @Override
    public Coordinate[] getNextMovements() {

        Coordinate[] nextMovements = new Coordinate[0];

        Coordinate myPosition = getCell().getCoordinate();
        Coordinate c;

        //Up
        c = myPosition.up();
        if(canAddToNextMovements(c)) nextMovements = Tool.add(c,nextMovements);

        //Down
        c = myPosition.down();
        if(canAddToNextMovements(c)) nextMovements = Tool.add(c,nextMovements);

        //Left
        c = myPosition.left();
        if(canAddToNextMovements(c)) nextMovements = Tool.add(c,nextMovements);

        //Right
        c = myPosition.right();
        if(canAddToNextMovements(c)) nextMovements = Tool.add(c,nextMovements);

        //Up Left
        c = myPosition.up().left();
        if(canAddToNextMovements(c)) nextMovements = Tool.add(c,nextMovements);

        //Up right
        c = myPosition.up().right();
        if(canAddToNextMovements(c)) nextMovements = Tool.add(c,nextMovements);

        //Down Left
        c = myPosition.down().left();
        if(canAddToNextMovements(c)) nextMovements = Tool.add(c,nextMovements);

        //Down Right
        c = myPosition.down().right();
        if(canAddToNextMovements(c)) nextMovements = Tool.add(c,nextMovements);

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
