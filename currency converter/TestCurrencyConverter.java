
/**
 *TestCurrencyConverter is a driver written to test
 *all the methods of the CurrencyConverter class
 * 
 * @author Lly Naoudom 
 * @version 5/26/2015
*/

import java.util.Scanner; //import statement to let the jvm know where the Scanner 
                          //class is located
public class TestCurrencyConverter
{
   public static void main(String[ ] args)
   {
       CurrencyConverter convert; //declare a reference variable
       Scanner input;//delclare a reference variable
       
       char currencyType;
       double amount;
       char goAgain = 'y';
       
       input = new Scanner(System.in);//create a Scanner object
       
       System.out.print(" Enter the currency type d, e, y, p: ");
       currencyType = input.next( ).charAt(0);
       
       System.out.print("Enter the amount of money: ");
       amount = input.nextDouble( );
       
       convert = new CurrencyConverter(amount, currencyType); //create a CurrencyConverter object
       
       //Test each currency and print the results for each test
       System.out.println("Test 1 set dollars");
       System.out.println(convert );
      input.nextLine( ); 
      
     while(goAgain == 'y')
     {
        System.out.print("\n Enter the currency type d, e, y, p: ");
        currencyType = input.next( ).charAt(0);
        
        System.out.print("Enter the amount: ");
        amount = input.nextDouble( );
        convert.setAmount(amount, currencyType);
      
       System.out.println("Test set ");
       System.out.println(convert );
        System.out.print("Enter y to convert again: ");
        input.nextLine( );
        goAgain = input.next( ).charAt(0);//how to read a single character
      }
      System.out.println("Good bye");
  
     //write two more sets of code like above to test the set with Yen and the set with Pounds                  
   }
   
}