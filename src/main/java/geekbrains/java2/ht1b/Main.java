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
			
	
	public static void main( String[] args ){

    new Play().Play();


	
	}
	

	
	

		

	
}
	
	
	


