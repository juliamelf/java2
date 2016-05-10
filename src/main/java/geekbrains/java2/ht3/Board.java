package geekbrains.java2.ht3;

import java.util.Arrays;
import java.util.Scanner;

class Board {

    static int boardSize = getBoardSize();
    private static final char EMPTY = '*';
    final static char USER = 'X';
    final static char COMP = 'O';
    static char [][] board = new char[boardSize][boardSize];

    //Получаем размер доски
    private static int getBoardSize() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите размер доски");
        return scanner.nextInt();
    }

    //Получаем значения в клетках на доске
    public static void initBoard() {
        for (int x = 0; x < boardSize; x++) {
            Arrays.fill(board[x], EMPTY);
        }
    }

    //Выводим поле в консоль
    static void printBoard() {
        System.out.print("\t");
        for (int i = 0; i < boardSize; i++) {
            System.out.printf("%4s",  i);
        }

        System.out.print("\n");
        for (int x = 0; x < boardSize; x++) {
            System.out.printf("%4d", x);
            System.out.print("| ");
            for (int y = 0; y < boardSize; y++) {
                System.out.print(board[x][y]  + " | ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    //Устанавливаем значение клетки поля
    public static void setValue(int x , int y , char charValue) {
         board[x][y] = charValue;
    }


}
