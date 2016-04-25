package geekbrains.java2.ht1b;

import java.util.Random;
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
			
	
	public void main( String[] args ){
	System.out.println("Игра в крестики-нолики");
	printBoard();
	
	String playerMove;
	String compMove;	
	
	while(true){
		System.out.println("Ваш ход");
		playerMove = playerMove();
		updateBoard(playerMove, "1");
		printBoard();
		if(winGame() == true){
			System.out.println("Вы выиграли!");			
			break;
		}
		
		System.out.println("Ход компьютера");
		compMove = computerMove();
		System.out.println("Компьютер ходит: " + compMove);
		updateBoard(compMove, "2");
		printBoard();		
		if(winGame() == true){
			System.out.println("Вы проиграли!");			
			break;
		}
		
	} 
	System.out.println("Игра закончена");	
	
	}
	
	//получаем значения в ячейках на доске
	private String getValue(String value){
		if(value == "1"){
			return " X";
		} else if(value == "2"){
			return " O";
		} else {
			return value;			
		}		
	}		
			
	//Выводим поле в консоль
	private void printBoard(){
		
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
	private String playerMove(){
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
	private boolean validMove(String move){
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
	private void updateBoard(String move, String player){
		
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
	private String computerMove(){
		for(int i = 0; i < 3; i++){
			if (board[i][0] == board[i][1]){
				return board[i][2];
			}
			else if (board[i][0] == board[i][2]){
				return board[i][1];
				
			}
			else if (board[i][1] == board [i][2]){
				return board[i][0];
			}			
		}
		
		for(int j = 0; j < 3; j++) {
			
		}
		
	
		
				
	}
	
	
	//Проверяем есть ли законченные линии
	private boolean playerFullRow(){
		
	}
		
	// Проверяем заполнен ли ряд
	private boolean checkRowValues(String s1, String s2, String s3){
		
		return((s1 == s2) && (s1 == s3));
		
	}	
	
	// Проверяем есть ли заполненные ряды
	private boolean checkFullRow(){
		for(int i = 0; i < board.length; i++) {
			if(checkRowValues(board[i][0], board[i][1], board[i][2]) == true){
				return true;
			}			
		}
		return false;
	}
	
	// Проверяем есть ли заполненные столбцы
	private boolean checkFullColumn(){
		for (int i = 0; i < board.length; i++){
			if (checkRowValues(board[0][i], board[1][i], board[2][i]) == true){
				return true;
			}
		}
		return false;
	}
	
	// Проверяем есть ли заполненные ряды по диагонали
	private boolean checkFullDiagonal(){
		if(checkRowValues(board[0][0], board[1][1], board[2][2]) == true || checkRowValues(board[0][2], board[1][1], board[2][0]) == true){
			return true;
		}
		return false;
	}
			
	// Проверяем есть ли победитель
	private boolean winGame(){
		if (checkFullRow() == true || checkFullColumn() == true || checkFullDiagonal() == true) {
			return true;
		}
		return false;
	}
	
}
	
	
	


