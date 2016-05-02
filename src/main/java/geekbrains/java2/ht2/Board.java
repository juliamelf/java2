package geekbrains.java2.ht2;

import java.util.Arrays;
import java.util.Scanner;

class Board {

    final static int SIZE = getBoardSize();
    private final static char EMPTY = '*';
    final static char USER = 'X' ;
    final static char COMP = 'O' ;
    static char [][] board = new char[SIZE][SIZE] ;

    //Получаем размер доски
    static int getBoardSize(){
        Scanner scanner = new Scanner(System.in) ;
        System.out.println("Выберите размер доски");
        return scanner.nextInt();
    }

    //Получаем значения в клетках на доске
    static void initBoard() {
        for (int x = 0; x < SIZE; x++) {
            Arrays.fill(board[x], EMPTY);
        }

    }

    //Выводим поле в консоль
    static void printBoard() {
        System.out.print(" " + "| ");
        for (int i = 0; i < SIZE; i++){
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
    public static void setValue(int x , int y , char charValue){
         board[x][y] = charValue;
    }

    //Проверяем доступен ли ход (клетка пустая, координаты корректные)
    public static boolean notValid(int x , int y ){
        if (x >= SIZE || y >= SIZE || x < 0 || y < 0 || board[x][y] != '*') {
            return true;
        }
        return false;
    }



 /*

    // Проверяем заполнен ли ряд
    private static boolean checkRowValues(String s1, String s2, String s3){

        return((s1 == s2) && (s1 == s3));

    }

    // Проверяем есть ли заполненные ряды
    private static boolean checkFullRow(){
        for(int i = 0; i < board.length; i++) {
            if(checkRowValues(board[i][0], board[i][1], board[i][2]) == true){
                return true;
            }
        }
        return false;
    }

    // Проверяем есть ли заполненные столбцы
    private static boolean checkFullColumn(){
        for (int i = 0; i < board.length; i++){
            if (checkRowValues(board[0][i], board[1][i], board[2][i]) == true){
                return true;
            }
        }
        return false;
    }

    // Проверяем есть ли заполненные ряды по диагонали
    private static boolean checkFullDiagonal(){
        if(checkRowValues(board[0][0], board[1][1], board[2][2]) == true || checkRowValues(board[0][2], board[1][1], board[2][0]) == true){
            return true;
        }
        return false;
    }

    // Проверяем есть ли победитель
    private static boolean winGame(){
        if (checkFullRow() == true || checkFullColumn() == true || checkFullDiagonal() == true) {
            return true;
        }
        return false;
    }
*/
}
