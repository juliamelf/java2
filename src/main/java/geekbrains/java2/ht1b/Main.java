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
			
	
	public static void main( String[] args ){
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
	public static String getValue(String value){
		if(value == "1"){
			return " X";
		} else if(value == "2"){
			return " O";
		} else {
			return value;			
		}		
	}		
			
	//Выводим поле в консоль
	public static void printBoard(){
		
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
	public static String playerMove(){
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
	public static boolean validMove(String move){
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
	public static void updateBoard(String move, String player){
		
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
	public static String computerMove(){
		
		if((A1 == "A1" & B1 == "1" & C1 == "1") || (B2 == "1" & C3 == "1" )){
			return "A1";
		}
		else if((B2 == "1" & C2 == "1") || (A1 == "1" & A3 == "1" )){
			return "A2";
		}
		else if((B3 == "1" & C3 == "1") || (B2 == "1" & C1 == "1" )){
			return "A3";
		}
		else if((B2 == "1" & B3 == "1") || (A1 == "1" & C1 == "1" )){
			return "B1";
		}
		else if((B1 == "1" & B3 == "1") || (A2 == "1" & C2 == "1" ) 
				|| (A1 == "1" & C3 == "1") || (A3 == "1" & C1 == "1")){
			return "B2";
		}
		else if((B1 == "1" & B2 == "1") || (A3 == "1" & C3 == "1" )){
			return "B3";
		}
		else if((A1 == "1" & B1 == "1") || (C2 == "1" & C3 == "1" )){
			return "C1";
		}
		else if((C1 == "1" & C3 == "1") || (B2 == "1" & A2 == "1" )){
			return "C2";
		}
		else if((B3 == "1" & A3 == "1") || (C2 == "1" & C1 == "1" )){
			return "C3";
		}		
	    else if((A1 == "A1" & A2 == "1")){
			return "A1";
		}
		else if((A2 == "A2" & (A1 == "1" || A3 == "1"))){
			return "A2";			
		}
		else if((A3 == "A3" & (A2 == "1"))){
			return "A3";
		}	
		else if((B1 == "B1" & (B2 == "1"))){
			return "B1";
		}
		else if((B2 == "B2" & (B1 == "1" || B3 == "1"))){
			return "B2";
		}
		else if((B3 == "B3" & (B2 == "1"))){
			return "B3";
		}	
		else if((C1 == "C1" & (C2 == "1"))){
			return "C1";
		}
		else if((C2 == "C2" & (C1 == "1" || C3 == "1"))){
			return "C2";
		}
		else if((C3 == "C3" & (C2 == "1"))){
			return "C3";
		}
		else if(
				((A1 == "A1") & (A2 == "2") & (A3 == "2")) ||
				((A1 == "A1") & (A2 == "2") & (A3 == "A3")) ||
				((A1 == "A1") & (A2 == "A2") & (A3 == "2"))				
			   ){
			    return "A1";
		        }
		else if(
				((A1 == "2") & (A2 == "A2") & (A3 == "2")) ||
				((A1 == "2") & (A2 == "A2") & (A3 == "A3")) ||
				((A1 == "A1") & (A2 == "A2") & (A3 == "2"))	
			   ){
			     return "A2";	
		        }
		else if(
				((A1 == "2") & (A2 == "2") & (A3 == "A3")) ||
				((A1 == "2") & (A2 == "A2") & (A3 == "A3")) ||
				((A1 == "A1") & (A2 == "2") & (A3 == "A3"))	
			   ){
			     return "A3";	
		        }
		else if(
				((B1 == "B1") & (B2 == "2") & (B3 == "2")) ||
				((B1 == "B1") & (B2 == "2") & (B3 == "B3")) ||
				((B1 == "B1") & (B2 == "B2") & (B3 == "2"))
			   ){
			     return "B1";
		        }
		else if(
				((B1 == "2") & (B2 == "B2") & (B3 == "2")) ||
				((B1 == "2") & (B2 == "B2") & (B3 == "B3")) ||
				((B1 == "B1") & (B2 == "B2") & (B3 == "2"))
			   ){
			     return "B2";
		        }
		else if(
				((B1 == "2") & (B2 == "2") & (B3 == "B3")) ||
				((B1 == "2") & (B2 == "B2") & (B3 == "B3")) ||
				((B1 == "B1") & (B2 == "2") & (B3 == "B3"))
			   ){
			     return "B3";
		        }
		else if(
				((C1 == "C1") & (C2 == "2") & (C3 == "2")) ||
				((C1 == "C1") & (C2 == "2") & (C3 == "C3")) ||
				((C1 == "C1") & (C2 == "C2") & (C3 == "2"))
			   ){
			     return "C1";
		        }
		else if(
				((C1 == "2") & (C2 == "C2") & (C3 == "2")) ||
				((C1 == "2") & (C2 == "C2") & (C3 == "C3")) ||
				((C1 == "C1") & (C2 == "C2") & (C3 == "2"))
			   ){
			     return "C2";
		        }
		else if(
				((C1 == "2") & (C2 == "2") & (C3 == "C3")) ||
				((C1 == "2") & (C2 == "C2") & (C3 == "C3")) ||
				((C1 == "C1") & (C2 == "2") & (C3 == "C3"))
			   ){
			     return "C3";
		        }		
		return "";		     
				
	}
		
	// Проверяем заполнен ли ряд
	private boolean checkRowValues(String s1, String s2, String s3){
		
		return((s1 == s2) && (s1 == s3));
		
	}	
	
	private boolean checkFullRow(){
		for(int i = 0; i < board.length; i++) {
			if(checkRowValues(board[i][0], board[i][1], board[i][2]) == true){
				return true;
			}			
		}
		return false;
	}
	
	private boolean checkFullColumn(){
		for (int i = 0; i < board.length; i++){
			if (checkRowValues(board[0][i], board[1][i], board[2][i]) == true){
				return true;
			}
		}
		return false;
	}
	
	private boolean checkFullDiagonal(){
		
	}
	
	
		
	
	private boolean winGame(){
		
	}
	
}
	
	
	


