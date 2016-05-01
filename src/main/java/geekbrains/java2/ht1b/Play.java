package geekbrains.java2.ht1b;

/**
 * Created by Julia on 5/1/2016.
 */
public class Play {


    public void Play() {
        Board.initBoard();
        Board.printBoard();
        Move.userMove();
        Board.printBoard();
        Move.compMove();
        Board.printBoard();
    }
/*
        System.out.println("Игра в крестики-нолики");
        printBoard();

        while(computerMove() != "Больше ходов нет. Ничья"){
            System.out.println("Ваш ход");
            updateBoard(playerMove(), "1");
            printBoard();
            if(winGame() == true){
                System.out.println("Вы выиграли!");
                break;
            }

            System.out.println("Ход компьютера");
            System.out.println("Компьютер ходит: " + computerMove());
            updateBoard(computerMove(), "2");
            printBoard();
            if(winGame() == true){
                System.out.println("Вы проиграли!");
                break;
            }

        }
        System.out.println("Игра закончена");

    }

    */
}
