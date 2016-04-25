package geekbrains.java2.ht1b;

import java.util.Scanner;

public class Main {
	
	/**
	 * Примерный план:
1) Создаем игровое поле в виде массива;
2) Пишем метод вывода поля в консоль(желательно чтобы выводились прямо символы Х, О, о);
3) В бесконечном цикле запрашиваем ход игрока, потом ход компьютера, до тех пор пока кто-нибудь не выиграет, или не закончатся пустые клетки;
4) Учитываем что при установке крестика или нолика место должно быть пустым, в противном случае необходим запрос на повторный ход;
5) Делаем проверку на победу одного из игроков;
6) Сделать несколько вариантов поведения АИ: 
Компьютерный игрок случайно ставит свои метки, либо продумывает свои ходы (блокирует линию игрока, и продолжает свою)
[b]Дополнительные условия(сложность увеличена)[/b]:
1) Программа реализуется в виде отдельных классов;
2) Размер поля и необходимой серии можно указывать(например поле 5х5 и серия 4 фишки в ряд)
3) Когда поле больше чем 3х3, компьютерный игрок должен стать намного умнее, иначе у него не будет шансов;
	 
	 */
	
	//глобальные переменные
	static String[][] board = {{"A1", "A2", "A3"}, {"B1", "B2", "B3"}, {"C1", "C2", "C3"}};	
	static Scanner scanner = new Scanner(System.in);
			
	
	public static void main( String[] args ){
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
	
	//получаем значения в ячейках на доске	
	private static String getValue(String value){
		if(value == "1"){
			return " X";
		} else if(value == "2"){
			return " O";
		} else {
			return value;			
		}		
	}			
			
	//Выводим поле в консоль
	private static void printBoard(){
		
		System.out.println("----------------");
		for (int i = 0; i < board.length; i++){
			System.out.print("| ");
			for(int j = 0; j < board[i].length; j++){
				System.out.print(getValue(board[i][j]) + " | ");
				
			}
			System.out.println();
			System.out.println("----------------");		
		}
		
		
	}
	
	
	//Ход игрока
	private static String playerMove(){
		String playerMove;	
		
		do{					
		   playerMove = scanner.nextLine();	
		   if (validMove(playerMove) == false)
		   {
			   System.out.println("Некорректное значение, выберите другое.");
		   }
		} while(validMove(playerMove) == false);
		return playerMove;		
	}
	
	//Некорректный ход
	private static boolean validMove(String move){
		if(move.equalsIgnoreCase("A1") && (board[0][0] == "A1"))
			return true;
		if(move.equalsIgnoreCase("A2") && (board[0][1] == "A2"))
			return true;
		if(move.equalsIgnoreCase("A3") && (board[0][2] == "A3"))
			return true;
		if(move.equalsIgnoreCase("B1") && (board[1][0] == "B1"))
			return true;
		if(move.equalsIgnoreCase("B2") && (board[1][1] == "B2"))
			return true;
		if(move.equalsIgnoreCase("B3") && (board[1][2] == "B3"))
			return true;
		if(move.equalsIgnoreCase("C1") && (board[2][0] == "C1"))
			return true;
		if(move.equalsIgnoreCase("C2") && (board[2][1] == "C2"))
			return true;
		if(move.equalsIgnoreCase("C3") && (board[2][2] == "C3"))
			return true;
		return false;
	}
	
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
	
}
	
	
	


