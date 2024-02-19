package model;

import view.Screen;

public class Main {
    public static void main(String[] args) {
        Board b1 = new Board();
        Screen.show(b1);

        b1.placePieces();
        Screen.show(b1);


    }
}
