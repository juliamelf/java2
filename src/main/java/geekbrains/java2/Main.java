package geekbrains.java2;

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
    }
    
    //ДЗ 1.1
    
    public static void array1(){   	
    	
    	int[] array1 = {0, 1, 0, 1, 0, 1, 0, 1, 0, 1};
    	
    	for(int i = 0; i < array1.length; i++){
    		System.out.println(array1[i]);
    	}    
    	
    }
    
    //ДЗ 1.2
    
    public static void array2(){   	
    	
    	int[] array2 = {0, 1, 0, 1, 0, 1, 0, 1, 0, 1};
    	
    	for(int i = 0; i < array2.length; i++){
    		if(array2[i] == 0){
    			array2[i] = -1;
    		} else{
    			array2[i] = 0;
    		}
    	}
    	
    	for(int i = 0; i < array2.length; i++){
    		System.out.println(array2[i]);
    	}    	
    }
    
    //ДЗ 1.3
    
    public static void array3(){	
    	
	    int[] array3 = new int [8]; 
	    array3[0] = 1;
	    for(int i = 1; i < array3.length; i++){
		    array3[i] = array3[i-1]+3;
	    }
	    for(int i = 0; i < array3.length; i++){		
		    System.out.println(array3[i]);
	    }	
    }
    
    //ДЗ 1.4       
    
    public static double addition(double x, double y){
    	double addResult;
    	addResult = x+y;
    	return addResult;
    }
    
    public static double subtraction(double x, double y){
    	double subResult;
    	subResult = x-y;
    	return subResult;    	
    }
    
    public static double multiplication(double x, double y){
    	double multResult;
    	multResult = x*y;
    	return multResult;    	
    }
    
    public static double division(double x, double y){
    	double divResult;
    	divResult = x/y;
        return divResult;    	
    }
    
   //ДЗ 1.5
       
    public static void formula(){  	
    	
    	double addResult = addition(2, 3);    	
    	double multResult = multiplication(addResult, 5);    	
    	double forResult = division(multResult, 2); 
    	System.out.println("((2+3)*5)/2 = " + forResult);
    	
    }
}
