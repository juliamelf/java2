package geekbrains.java2.ht2;

class Play {

    private final int WIN_SIZE = Board.SIZE;

    public void gamePlay() {
        System.out.println("Игра в крестики-нолики");

        Board.initBoard();
        Board.printBoard();

        while (true) {

            Move.userMove();
            Board.printBoard();

            boolean isUserWin = winGame(Board.USER);
            if (isUserWin) {
                System.out.println("Вы выиграли!");
                break;
            }

            Move.compMove();
            Board.printBoard();

            boolean isCompWin = winGame(Board.COMP);
            if (isCompWin) {
                System.out.println("Вы проиграли!");
                break;
            }

        }
    }

    //Проверяем заполнен ли ряд
    private boolean checkLine(char[] lineToTest, char testChar){
        int testCharInLine = 0 ;
        for ( int x = 0; x < lineToTest.length; x++ ){
            if(lineToTest[x] == testChar){
                testCharInLine ++ ;
            }
        }

        return testCharInLine == WIN_SIZE;
    }

    //Проверяем выиграл ли игрок
    private boolean winGame(char charToTest) {
        //Проверяем каждый ряд на заполнение
        for (int y = 0; y < Board.SIZE; y ++){
            char[] lineToTest = Board.board[y] ;
            if(checkLine(lineToTest, charToTest)){
                return  true ;
            }
        }

        //Инвертируем матрицу
        char [] [] testBoard = new char[Board.SIZE][Board.SIZE] ;
        for (int x=0; x < Board.SIZE; x++ ){
            for (int y=0; y < Board.SIZE; y++ ){
                testBoard[x][y] =  Board.board[y][x];
            }
        }

        //Проверяем каждый ряд на заполнение для инвертированной матрицы
        for (int y = 0; y < Board.SIZE; y++){
            char[] columnToTest = testBoard[y] ;
            if(checkLine(columnToTest, charToTest)){
                return  true ;
            }
        }
        return false ;
    }



/*


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
