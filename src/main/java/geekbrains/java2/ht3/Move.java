package geekbrains.java2.ht3;

import java.util.Random;
import java.util.Scanner;


class Move {

    //Считываем значения введенные игроком
    private static int getUserMove() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    //Ход игрока
    public static void userMove() {
        int userX;
        int userY;
        System.out.println("Ход игрока.");
        System.out.println("Выберите координаты X и Y.");
        do {
            userX = getUserMove();
            userY = getUserMove();
            if (notValid(userX, userY)) {
                System.out.println("Некорректное значение, выберите другое.");
            }
        } while (notValid(userX, userY));
        Board.setValue(userX, userY, Board.USER);
    }

    //Проверяем доступен ли ход (клетка пустая, координаты корректные)
    private static boolean notValid(int x , int y ) {
        if (x >= Board.boardSize || y >= Board.boardSize || x < 0 || y < 0 || Board.board[x][y] != '*') {
            return true;
        }
        return false;
    }

    //Ход компьютера
    public static void compMove() {
        int compX;
        int compY;
        System.out.println("Ход компьютера.");
        do {
            compX = new Random().nextInt(Board.boardSize);
            compY = new Random().nextInt(Board.boardSize);
        } while (notValid(compX, compY));
        Board.setValue(compX, compY, Board.COMP);
        System.out.println("Компьютер ходит " + compX + " " + compY + ".");
    }

}
