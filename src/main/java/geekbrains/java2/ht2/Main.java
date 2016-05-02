package geekbrains.java2.ht2;

public class Main {

	/**
	 *
	 * После полного разбора необходимо доработать некоторый функционал, задачи идут по усложнению:
	 + 1) Сделать при запуске запрос на размер поля и необходимого размера серии;
	 + 2) При распечатке поля, указывать по краям координаты х и у, чтобы игроку было проще ставить метки;
	 Примечание: Если будете выводить размер поля больше чем 9х9, тогда для подстановки координат необходимо воспользоваться
	 методов printf
	 + 3) В методе проверки пустая ли ячейка ввести условия на недопустимые координаты(
	 т.е. если размер поля 3х3, то при вызове метода isCellEmpty(2, 5) - он должен возвращать false, чтобы ни игрок,
	 ни компьютер не могли даже попытаться поставить фишку за пределы поля), также добавить проверку на отрицательные значения
	 6) Возможность дать фору одному из игроков(в начале игры для игрока должны быть поставлены несколько фишек(
	 мы можем указывать их число 1-5), при этом фишки не должны быть поставлены рядом);
	 7) Научить компьютер целенаправленно строить свою серию, и доработать аи(самая сложная часть);
	 Когда дописываете свои блоки обязательно нужно ставить комментарии с описанием того что там происходит.
     */
			
	
	public static void main( String[] args ){

    new Play().Play();


	
	}
	

	
	

		

	
}
	
	
	


