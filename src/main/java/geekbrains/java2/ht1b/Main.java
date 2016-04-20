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
	static String A1 = "A1", A2 = "A2",  A3 = "A3", B1 = "B1", B2 = "B2", B3 = "B3", C1 = "C1", C2 = "C2", C3 = "C3";	
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
	
	
	//Ход игрока
	public static String playerMove(){
		String playerMove;		
		playerMove = scanner.nextLine();	
		return playerMove;		
	}
	
	//Обновляем поле после хода 
	public static void updateBoard(String move, String player){
		
		if(move.equalsIgnoreCase("A1")){
			A1 = player;
		}
		if(move.equalsIgnoreCase("A2")){
			A2 = player;
		}
		if(move.equalsIgnoreCase("A3")){
			A3 = player;
		}
		if(move.equalsIgnoreCase("B1")){
			B1 = player;
		}
		if(move.equalsIgnoreCase("B2")){
			B2 = player;
		}
		if(move.equalsIgnoreCase("B3")){
			B3 = player;
		}
		if(move.equalsIgnoreCase("C1")){
			C1 = player;
		}
		if(move.equalsIgnoreCase("C2")){
			C2 = player;
		}
		if(move.equalsIgnoreCase("C3")){
			C3 = player;
		}	
		      
	}		   
	
	//получаем значения переменных
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
			
		System.out.println(getValue(A1)  + " | " + getValue(A2) + " | " + getValue(A3) );
		System.out.println("---|----|---");
		System.out.println(getValue(B1)  + " | " + getValue(B2) + " | " + getValue(B3) );
		System.out.println("---|----|---");
		System.out.println(getValue(C1)  + " | " + getValue(C2) + " | " + getValue(C3) );
			
	}
			
	
	//Ход компьютера
	public static String computerMove(){	
			
		if(A1 == "A1")
			return "A1";
		if(A2 == "A2")
			return "A2";		
		if(A3 == "A3")
			return "A3";		
		if(B1 == "B1")
			return "B1";
		if(B2 == "B2")
			return "B2";
		if(B3 == "B3")
			return "B3";
		if(C1 =="C1")
			return "C1";
		if(C2 == "C2")
			return "C2";
		if(C3 == "C3")
			return "C3";
		return "";
				
	}
		
	// Проверяем заполнен ли ряд
	public static boolean fullRow(String s1, String s2, String s3){
		
		return((s1 == s2) && (s1 == s3));
		
	}		
		
	// Проверяем нет ли выигрыша	
	public static boolean winGame(){
		if(fullRow(A1, A2, A3))
			return true;
		if(fullRow(B1, B2, B3))
			return true;
		if(fullRow(C1, C2, C3))
			return true;
		if(fullRow(A1, B2, C3))
			return true;
		if(fullRow(A3, B2, C1))
			return true;
		if(fullRow(A1, B1, C1))
			return true;
		if(fullRow(A2, B2, C3))
			return true;
		if(fullRow(A3, B3, C3))
			return true;
		return false;	
	}
	
}
	
	
	


