package geekbrains.java2.ht3;


class Play {

    private final int WIN_SIZE = Board.SIZE;

    public Play(){
        Board board = new Board();
        gamePlay();
    }

    private void gamePlay() {

        Board.printBoard();

        while (!boardFull()) {

            Move.userMove();
            Board.printBoard();

            if (winGame(Board.USER)) {
                System.out.println("Вы выиграли!");
                break;
            }

            if (!boardFull()){
                Move.compMove();
                Board.printBoard();

                if (winGame(Board.COMP)) {
                    System.out.println("Вы проиграли!");
                    break;
                }

            }

            }

        System.out.println("Игра закончена");
    }

    //Проверяем осталось ли место на доске
    private boolean boardFull()  {
        int numSpots =  Board.SIZE* Board.SIZE;
        int numSpotsFilled = 0;
        for(int i = 0; i < Board.SIZE; i++)  {
            for(int j = 0; j < Board.SIZE; j++)  {
                if(Board.board[i][j] != '*')
                    numSpotsFilled++;
            }
        }

        return numSpotsFilled == numSpots;
    }

    //Проверяем заполнен ли ряд
    private boolean checkLine(char[] lineToTest, char testChar) {
        int testCharInLine = 0 ;
        for (char aLineToTest : lineToTest) {
            if (aLineToTest == testChar) {
                testCharInLine++;
            }
        }

        return testCharInLine == WIN_SIZE;
    }

    //Проверяем выиграл ли игрок
    private boolean winGame(char charToTest) {
        //Проверяем каждый ряд на заполнение
        for (int y = 0; y < Board.SIZE; y ++) {
            char[] lineToTest = Board.board[y] ;
            if (checkLine(lineToTest, charToTest)) {
                return true ;
            }
        }

        //Инвертируем матрицу
        char [][] testBoard = new char[Board.SIZE][Board.SIZE];
        for (int x = 0; x < Board.SIZE; x++ ) {
            for (int y = 0; y < Board.SIZE; y++ ) {
                testBoard[x][y] =  Board.board[y][x];
            }
        }

        //Проверяем каждый ряд на заполнение для инвертированной матрицы
        for (int y = 0; y < Board.SIZE; y++) {
            char[] columnToTest = testBoard[y];
            if (checkLine(columnToTest, charToTest)) {
                return true;
            }
        }

        //Проверяем одну диагональ на заполнение
        int numFound = 0;
        for(int i = 0; i < Board.SIZE; i++)  {
            if(Board.board[i][i] == charToTest)
                numFound++;
        }

        if(numFound == WIN_SIZE)
            return true;

        //Проверяем вторую диагональ на заполнение
        numFound = 0;
        int numTest = Board.SIZE - 1;
        for(int i = 0; i < Board.SIZE; i++)  {
            if(Board.board[i][numTest-i] == charToTest)
                numFound++;
        }

        return numFound == WIN_SIZE;

    }
}
