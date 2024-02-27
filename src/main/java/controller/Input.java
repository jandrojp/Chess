package controller;

import view.Console;

import java.util.Scanner;

public class Input {

    /**
     *
     * @param message Message that arrives asking for an integer
     * @return Returns an integer
     */
    public static int getInteger(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        while(!sc.hasNextInt()){
            System.out.print("                                                                " + Console.ANSI_RED + "   ERROR, WRITE A INTEGER NUMBER ! \uD83D\uDE21 " + Console.ANSI_RESET);
            System.out.println();
            System.out.print(message);
            sc.next();
        }
        return sc.nextInt();
    }

    /**
     *
     * @return Returns a coordinate as a String
     */
    public static String getCoordinate() {

        Scanner sc = new Scanner(System.in);

        System.out.print("                                                  Enter a coordinate ➡️ ");
        String coordinate = sc.next();
        coordinate = coordinate.toUpperCase();

        return coordinate;
    }
}
