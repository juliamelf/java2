package geekbrains.java2.ht2;

import java.util.Arrays;

public class Board {

    final static int SIZE = 3 ;
    final static int WIN_SIZE = 3;
    final static char EMPTY = '*';
    final static char USER = 'X' ;
    final static char COMP = 'O' ;
    static char [][] board = new char[SIZE][SIZE] ;

    //Получаем значения в клетках на доске
    static void initBoard() {
        for (int x = 0; x < SIZE; x++) {
            Arrays.fill(board[x], EMPTY);
        }

    }

    //Выводим поле в консоль
    static void printBoard() {

        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                System.out.print(board[x][y] + "\t");
            }
            System.out.print("\n");
        }
        System.out.print("\n");

    }

    //Устанавливаем значение клетки поля
    public static void setValue(int x , int y , char charValue){
         board[x][y] = charValue;
    }

    //Проверяем пустая ли клетка
    public static boolean isEmpty(int x , int y ){
        return board[x][y] == '*' ? true : false ;
    }

/*
        System.out.println("----------------");
        for (int i = 0; i < board.length; i++){
            System.out.print("| ");
            for(int j = 0; j < board[i].length; j++){
                System.out.print(getValue(board[i][j]) + " | ");

            }
            System.out.println();
            System.out.println("----------------");
        }
*/


/*
    //Записываем новые значения в ячейки после хода
    private static void updateBoard(String move, String player){

        if(move.equalsIgnoreCase("A1")){
            board[0][0] = player;
        }
        if(move.equalsIgnoreCase("A2")){
            board[0][1] = player;
        }
        if(move.equalsIgnoreCase("A3")){
            board[0][2] = player;
        }
        if(move.equalsIgnoreCase("B1")){
            board[1][0] = player;
        }
        if(move.equalsIgnoreCase("B2")){
            board[1][1] = player;
        }
        if(move.equalsIgnoreCase("B3")){
            board[1][2] = player;
        }
        if(move.equalsIgnoreCase("C1")){
            board[2][0] = player;
        }
        if(move.equalsIgnoreCase("C2")){
            board[2][1] = player;
        }
        if(move.equalsIgnoreCase("C3")){
            board[2][2] = player;
        }

    }

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
