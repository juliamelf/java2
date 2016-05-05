package geekbrains.java2.ht2;

import java.util.Arrays;
import java.util.Scanner;

class Board {

    final static int SIZE = getBoardSize();
    private final static char EMPTY = '*';
    final static char USER = 'X';
    final static char COMP = 'O';
    static char [][] board = new char[SIZE][SIZE];

    public Board(){
        initBoard();
    }

    //Получаем размер доски
    private static int getBoardSize() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите размер доски");
        return scanner.nextInt();
    }

    //Получаем значения в клетках на доске
    private static void initBoard() {
        for (int x = 0; x < SIZE; x++) {
            Arrays.fill(board[x], EMPTY);
        }
    }

    //Выводим поле в консоль
    static void printBoard() {
        System.out.print(" " + "| ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i+ " | ");
        }

        System.out.print("\n");
        for (int x = 0; x < SIZE; x++) {
            System.out.print(x);
            System.out.print("| ");
            for (int y = 0; y < SIZE; y++) {
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
