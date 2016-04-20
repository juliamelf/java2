package geekbrains.java2;

import java.util.Random;

public class Main 
{
	
    public static void main( String[] args )
    {
        System.out.println( "JAVA-2: Homework-1" );
        
        System.out.println( "Task 1.1" );
        array1();          
        System.out.println( "Task 1.2" );
        array2();       
        System.out.println( "Task 1.3" );
        array3();    
        System.out.println( "Task 1.4" );
        System.out.println("Результат сложения чисел = " + addition(7.0, 10.0));
        System.out.println("Результат вычитания чисел = " + subtraction(7.0, 10.0));
        System.out.println("Результат умножения чисел = " + multiplication(7.0, 10.0));
        System.out.println("Результат деления чисел = " + division(7.0, 10.0));
        System.out.println( "Task 1.5" );
        formula();
        System.out.println( "Task 1.6" );
        arrayMinMax();
    }
    
    //ДЗ 1.1    
    // 1) Создать массив mas[] состоящий из элементов 0 1 0 1 0 1 0 1 0 1;
    public static void array1(){   	
    	
    	int[] mas = {0, 1, 0, 1, 0, 1, 0, 1, 0, 1}; //задаем массив
    	
    	for(int i = 0; i < mas.length; i++){ //выводим элементы массива на консоль
    		System.out.println(mas[i]);
    	}    
    	
    }
    
    //ДЗ 1.2
    // 2) Инвертировать массив из п. 1, т. е. элементы 1 должны стать 0, а элементы 0 - 1.
    
    public static void array2(){   	
    	
    	int[] array2 = {0, 1, 0, 1, 0, 1, 0, 1, 0, 1}; //задаем массив
    	
    	for(int i = 0; i < array2.length; i++){ //инвертируем элементы массива
    		if(array2[i] == 0){
    			array2[i] = -1;
    		} else{
    			array2[i] = 0;
    		}
    	}
    	
    	for(int i = 0; i < array2.length; i++){ // выводим элементы массива на консоль
    		System.out.println(array2[i]);
    	}    	
    }
    
    //ДЗ 1.3
    // 3) С помощью цикла создать массив: 1 4 7 10 13 16 19 22
    
    public static void array3(){	
    	
	    int[] array3 = new int [8]; // задаем массив
	    array3[0] = 1; // задаем первый элемент массива
	    for(int i = 1; i < array3.length; i++){ // вычисляем последующие элементы массива
		    array3[i] = array3[i-1]+3;
	    }
	    for(int i = 0; i < array3.length; i++){	// выводим элементы массива на консоль	
		    System.out.println(array3[i]);
	    }	
    }
    
    //ДЗ 1.4  
    // 4) Написать методы для сложения, вычитания, деления и умножения двух чисел.
    // (на вход метода подается два параметра, на выходе получаем возвращаемый результат)
    
    public static double addition(double x, double y){//метод сложения двух чисел
    	double addResult;
    	addResult = x+y;
    	return addResult;
    }
    
    public static double subtraction(double x, double y){//метод вычитания двух чисел
    	double subResult;
    	subResult = x-y;
    	return subResult;    	
    }
    
    public static double multiplication(double x, double y){//метод умножения двух чисел
    	double multResult;
    	multResult = x*y;
    	return multResult;    	
    }
    
    public static double division(double x, double y){//метод деления двух чисел
    	double divResult;
    	divResult = x/y;
        return divResult;    	
    }
    
   //ДЗ 1.5
   // 5) Только с помощью написанных методов из п.4 выполнить расчет выражения ((2 + 3) * 5) / 2 
       
    public static void formula(){ //метод вычисления формулы
    	
    	double addResult = addition(2, 3);  
    	double multResult = multiplication(addResult, 5);     	
    	double forResult = division(multResult, 2); 
    	System.out.println("((2+3)*5)/2 = " + forResult); 
    	
    }
    
    //ДЗ 1.6
    // 6) Задать массив и найти в нем минимальный и максимальный элементы.
    // Результаты выполнения всех пунктов необходимо выводить в консоль.
    
    public static void arrayMinMax() {
    	
    	//задаем массив случайных чисел
    	System.out.println("Массив чисел:");
    	int[] myArray = new int [10];
    	for(int i = 0; i < myArray.length; i++){
    		myArray[i] = new Random().nextInt(); 
    		System.out.println(myArray[i]);
    	}
    	
    	//вычисляем минимальный элемент в массиве
    	int minNumber = 0;
    	for(int i = 0; i < myArray.length; i++){
    		
    		if(myArray[i] < minNumber){
    			minNumber = myArray[i];    			
    		}       		
    	}    	
    	System.out.println("Минимальное число = " + minNumber);
    	
    	//вычисляем максимальный элемент в массиве
    	int maxNumber = 0;
    	for(int i = 0; i < myArray.length; i++){
    		
    		if(myArray[i] > maxNumber){
    			maxNumber = myArray[i];    			
    		}       		
    	}    	
    	System.out.println("Максимальное число = " + maxNumber);    	
    }
}
