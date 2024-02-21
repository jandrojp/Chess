package model;

public class Coordinate {

    private char letter;
    private int number;

    public Coordinate(char letter, int number){
        this.letter = letter;
        this.number = number;
    }

    public char getLetter() {
        return letter;
    }
    public int getNumber() {
        return number;
    }

    public Coordinate up(){
        return new Coordinate(letter, number - 1);
    }
    public Coordinate down(){
        return new Coordinate(letter, number + 1);
    }
    public Coordinate left(){ return new Coordinate((char) (letter - 1), number); }
    public Coordinate right(){
        return new Coordinate((char) (letter + 1), number);
    }
    public Coordinate diagonalUpLeft(){
        return new Coordinate((char) (letter - 1), number - 1);
    }
    public Coordinate diagonalUpRight(){
        return new Coordinate((char) (letter + 1), number - 1);
    }
    public Coordinate diagonalDownLeft(){
        return new Coordinate((char) (letter - 1), number + 1);
    }
    public Coordinate diagonalDownRight(){
        return new Coordinate((char) (letter + 1), number + 1);
    }

    @Override
    public String toString() {
        return "(" + letter + ", " + number + ")";
    }
    @Override
    public boolean equals(Object obj) {

        if (obj == null) return false;
        if (!(obj instanceof Coordinate)) return false;

        Coordinate coordinate = (Coordinate) obj;

        return (coordinate.letter == this.letter &&
                coordinate.number == this.number);
    }

    @Override public int hashCode() {
        return number;
    }

    /**
     *
     * @param coordinate Coordinate that the user writes in the form of String
     * @return Returns false if the coordinate has a length other than 2 and true if it is equal to 2
     */
    public static boolean wrongLenght(String coordinate) {
        return coordinate.length() != 2;
    }

    /**
     *
     * @param letter First character of the coordinate entered by the user
     * @return Returns false if the character is less than the character 'A' or greater than the character 'H' and true if it is within
     */
    public static boolean letterErrorEasy(char letter) {
        return letter < 'A' || letter > 'H';
    }

    /**
     *
     * @param number Second character of the coordinate entered by the user
     * @return Returns false if the character is less than the character '0' or greater than the character '9' and true if it is within
     */
    public static boolean numberErrorEasy(char number) { return number < '0' || number > '8'; }

}
