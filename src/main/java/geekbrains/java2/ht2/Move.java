package geekbrains.java2.ht2;

import java.util.Random;
import java.util.Scanner;

class Move {

    //Считываем значения введенные игроком
    static int getUserMove(){
        Scanner scanner = new Scanner(System.in) ;
        return scanner.nextInt();
    }

    //Ход игрока
    public static void userMove(){
        int userX,userY;
        System.out.println("Ход игрока.");
        System.out.println("Выберите координаты X и Y.");
        do {
            userX = getUserMove();
            userY = getUserMove();
            if (Board.notValid(userX,userY))
            {
                System.out.println("Некорректное значение, выберите другое.");
            }
        }while (Board.notValid(userX,userY));
        Board.setValue(userX,userY,Board.USER);
    }

    //Ход компьютера
    public static void compMove(){
        int compX,compY;
        System.out.println("Ход компьютера.");
        do {
            compX = new Random().nextInt(Board.SIZE);
            compY = new Random().nextInt(Board.SIZE);
        }while (Board.notValid(compX,compY));
        Board.setValue(compX,compY, Board.COMP);
        System.out.println("Компьютер ходит " + compX + " " + compY + ".");
    }






/*





    //Ход компьютера
    private static  String computerMove(){

        //блокируем линию по горизонтали
        for(int i = 0; i < 3; i++){
            if (board[i][0] == board[i][1] && validMove(board[i][2]) == true){
                return board[i][2];
            } else if (board[i][0] == board[i][2] && validMove(board[i][1]) == true){
                return board[i][1];
            } else if (board[i][1] == board [i][2] && validMove(board[i][0]) == true){
                return board[i][0];
            }
        }

        //блокируем линию по вертикали
        for(int j = 0; j < 3; j++) {
            if (board[0][j] == board[1][j] && validMove(board[2][j]) == true){
                return board[2][j];
            } else if (board[0][j] == board[2][j] && validMove(board[1][j]) == true){
                return board[1][j];
            } else if (board[1][j] == board[2][j] && validMove(board[0][j]) == true){
                return board[0][j];
            }
        }

        //блокируем линию по диагонали
        if(board[0][0] == board[1][1] && validMove(board[2][2]) == true){
            return board[2][2];
        } else if (board[0][0] == board[2][2] && validMove(board[1][1]) == true){
            return board[1][1];
        } else if (board[1][1] == board[2][2] && validMove(board[0][0]) == true){
            return board[0][0];
        }

        if(board[0][2] == board[1][1] && validMove(board[2][0]) == true){
            return board[2][0];
        } else if (board[0][2] == board[2][0] && validMove(board[1][1]) == true){
            return board[1][1];
        } else if (board[1][1] == board[2][0] && validMove(board[0][2]) == true){
            return board[0][2];
        }

        //свой ход
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] != "1" && board[i][j] != "2"){
                    return board[i][j];
                }

            }

        }
        return "Больше ходов нет. Ничья";

    }
*/
}
