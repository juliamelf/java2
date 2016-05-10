package geekbrains.java2.ht3;


class Play {

    private final int WINSIZE = Board.boardSize;
    Board board = new Board();

    public void gamePlay() {

        board.initBoard();
        board.printBoard();

        while (!boardFull()) {

            Move.userMove();
            board.printBoard();

            if (winGame(board.USER)) {
                System.out.println("Вы выиграли!");
                break;
            }

            if (!boardFull()) {
                Move.compMove();
                board.printBoard();

                if (winGame(board.COMP)) {
                    System.out.println("Вы проиграли!");
                    break;
                }

            }

            }

        System.out.println("Игра закончена");
    }

    //Проверяем осталось ли место на доске
    private boolean boardFull()  {
        int numSpots =  board.boardSize * board.boardSize;
        int numSpotsFilled = 0;
        for (int i = 0; i < board.boardSize; i++)  {
            for (int j = 0; j < board.boardSize; j++)  {
                if (board.board[i][j] != '*') {
                    numSpotsFilled++;
                }
            }
        }

        return numSpotsFilled == numSpots;
    }

    //Проверяем заполнен ли ряд
    private boolean checkLine(char[] lineToTest, char testChar) {
        int testCharInLine = 0;
        for (char aLineToTest : lineToTest) {
            if (aLineToTest == testChar) {
                testCharInLine++;
            }
        }

        return testCharInLine == WINSIZE;
    }

    //Проверяем выиграл ли игрок
    private boolean winGame(char charToTest) {
        //Проверяем каждый ряд на заполнение
        for (int y = 0; y < board.boardSize; y++) {
            char[] lineToTest = board.board[y];
            if (checkLine(lineToTest, charToTest)) {
                return true;
            }
        }

        //Инвертируем матрицу
        char [][] testBoard = new char[board.boardSize][board.boardSize];
        for (int x = 0; x < board.boardSize; x++ ) {
            for (int y = 0; y < board.boardSize; y++ ) {
                testBoard[x][y] =  board.board[y][x];
            }
        }

        //Проверяем каждый ряд на заполнение для инвертированной матрицы
        for (int y = 0; y < board.boardSize; y++) {
            char[] columnToTest = testBoard[y];
            if (checkLine(columnToTest, charToTest)) {
                return true;
            }
        }

        //Проверяем одну диагональ на заполнение
        int numFound = 0;
        for (int i = 0; i < board.boardSize; i++)  {
            if (board.board[i][i] == charToTest) {
                numFound++;
            }
        }

        if (numFound == WINSIZE)
            return true;

        //Проверяем вторую диагональ на заполнение
        numFound = 0;
        int numTest = board.boardSize - 1;
        for (int i = 0; i < board.boardSize; i++) {
            if (board.board[i][numTest - i] == charToTest) {
                numFound++;
            }
        }

        return numFound == WINSIZE;

    }
}
