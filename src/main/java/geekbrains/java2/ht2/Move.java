package geekbrains.java2.ht2;

import java.util.Random;
import java.util.Scanner;

class Move {

    //Считываем значения введенные игроком
    private static int getUserMove() {
        Scanner scanner = new Scanner(System.in) ;
        return scanner.nextInt();
    }

    //Ход игрока
    public static void userMove() {
        int userX, userY;
        System.out.println("Ход игрока.");
        System.out.println("Выберите координаты X и Y.");
        do {
            userX = getUserMove();
            userY = getUserMove();
            if (notValid(userX, userY))
            {
                System.out.println("Некорректное значение, выберите другое.");
            }
        }while (notValid(userX, userY));
        Board.setValue(userX, userY, Board.USER);
    }

    //Проверяем доступен ли ход (клетка пустая, координаты корректные)
    private static boolean notValid(int x , int y ) {
        if (x >= Board.SIZE || y >= Board.SIZE || x < 0 || y < 0 || Board.board[x][y] != '*') {
            return true;
        }
        return false;
    }

    //Ход компьютера
    public static void compMove() {
        int compX, compY;
        System.out.println("Ход компьютера.");
        do {
            compX = new Random().nextInt(Board.SIZE);
            compY = new Random().nextInt(Board.SIZE);
        }while (notValid(compX, compY));
        Board.setValue(compX, compY, Board.COMP);
        System.out.println("Компьютер ходит " + compX + " " + compY + ".");
    }
/*
    private boolean winner(int lastR, int lastC)  {

        boolean winner = false; //assume there's no winner
        char symbol = board[lastR][lastC]; //the symbol for the last move either X or O

        //check left-right
        //the last move we made was in the row lastR, check that row for three of the same symbol
        int numFound = 0;
        for(int c = 0; c < 3; c++)  {
            if(board[lastR][c] == symbol)
                numFound++;
        }

        if(numFound == 3)
            winner = true;

        //check up-down
        //the last move we made was in the column lastC, check that column for three of the same symbol
        numFound = 0;
        for(int r = 0; r < 3; r++)  {
            if(board[r][lastC] == symbol)
                numFound++;
        }

        if(numFound == 3)
            winner = true;

        //check both diagonals
        numFound = 0;
        for(int i = 0; i < 3; i++)  {
            if(board[i][i] == symbol)
                numFound++;
        }

        if(numFound == 3)
            winner = true;

        numFound = 0;
        for(int i = 0; i < 3; i++)  {
            if(board[i][2-i] == symbol)
                numFound++;
        }

        if(numFound == 3)
            winner = true;

        return winner;
    }
    */
}
