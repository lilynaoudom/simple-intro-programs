//import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Scanner;

/**
 * This method test the Fraction class operation and print result depend on user choice.
 * @author Phat Pham Lily Naoudom <ppham5@uncc.edu>
 * @version 2015/07/7/16/2015
 */
public class FractionDriver
{
    public static void main(String[] args)
    {
        int choice;
        int choice1;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What would you like to do?");
        //Menu for user to choose what operations to perform
        //until user choose to quit
        do {
            System.out.println("1/ Addition\n2/ Subtraction\n3/ Multiply\n4/ Divide\n5/ Compare 2 fractions\n6/Random Generate Fraction" +
                                "\n7/ Equal\n8/ Convert Fraction to Decimal");
            choice = keyboard.nextInt();
            //If choice = 1 do addition
            if (choice == 1)
            {
                System.out.println("1st Fraction: Enter numerator");
                int firstNum = keyboard.nextInt();
                System.out.println("1st Fraction: Enter denominator");
                int firstDeno = keyboard.nextInt();
                Fraction frac1 = new Fraction(firstNum, firstDeno);
                System.out.println("2nd Fraction: Enter numerator");
                int secondNum = keyboard.nextInt();
                System.out.println("2nd Fraction: Enter denominator");
                int secondDeno = keyboard.nextInt();
                Fraction frac2 = new Fraction(secondNum, secondDeno);
                System.out.println(frac1.add(frac1, frac2));
            }
            //If choice  = 2 do subtraction
            else if ( choice == 2)
            {
                System.out.println("1st Fraction: Enter numerator");
                int firstNum = keyboard.nextInt();
                System.out.println("1st Fraction: Enter denominator");
                int firstDeno = keyboard.nextInt();
                Fraction frac1 = new Fraction(firstNum, firstDeno);
                System.out.println("2nd Fraction: Enter numerator");
                int secondNum = keyboard.nextInt();
                System.out.println("2nd Fraction: Enter denominator");
                int secondDeno = keyboard.nextInt();
                Fraction frac2 = new Fraction(secondNum, secondDeno);
                System.out.println(frac1.sub(frac1, frac2));
            }
            //If choice  = 3 do multiplication
            else if (choice == 3)
            {
                System.out.println("1st Fraction: Enter numerator");
                int firstNum = keyboard.nextInt();
                System.out.println("1st Fraction: Enter denominator");
                int firstDeno = keyboard.nextInt();
                Fraction frac1 = new Fraction(firstNum, firstDeno);
                System.out.println("2nd Fraction: Enter numerator");
                int secondNum = keyboard.nextInt();
                System.out.println("2nd Fraction: Enter denominator");
                int secondDeno = keyboard.nextInt();
                Fraction frac2 = new Fraction(secondNum, secondDeno);
                System.out.println(frac1.multiply(frac1, frac2));
            }
            ////If choice = 4 do division
            else if (choice == 4)
            {
                System.out.println("1st Fraction: Enter numerator");
                int firstNum = keyboard.nextInt();
                System.out.println("1st Fraction: Enter denominator");
                int firstDeno = keyboard.nextInt();
                Fraction frac1 = new Fraction(firstNum, firstDeno);
                System.out.println("2nd Fraction: Enter numerator");
                int secondNum = keyboard.nextInt();
                System.out.println("2nd Fraction: Enter denominator");
                int secondDeno = keyboard.nextInt();
                Fraction frac2 = new Fraction(secondNum, secondDeno);
                System.out.println(frac1.division(frac1, frac2));
            }
            //If choice  = 5 compare 2 fractions
            else if ( choice == 5)
            {
                System.out.println("1st Fraction: Enter numerator");
                int firstNum = keyboard.nextInt();
                System.out.println("1st Fraction: Enter denominator");
                int firstDeno = keyboard.nextInt();
                Fraction frac1 = new Fraction(firstNum, firstDeno);
                System.out.println("2nd Fraction: Enter numerator");
                int secondNum = keyboard.nextInt();
                System.out.println("2nd Fraction: Enter denominator");
                int secondDeno = keyboard.nextInt();
                Fraction frac2 = new Fraction(secondNum, secondDeno);
                if (frac1.compareTo(frac1, frac2) == 1)
                {
                    System.out.print(frac1 + " > " + frac2);
                }
                else if (frac1.compareTo(frac1, frac2) == -1)
                {
                    System.out.print(frac1 + " < " + frac2);
                }
                else
                    System.out.print(frac1 + " = " + frac2);
            }
            //If choice  = 6 generate a random fraction and simplifies
            else if ( choice == 6)
            {
                Fraction random = new Fraction();
                System.out.print(random.random());
            }
            //If choice  = 7 check if the fraction are equal or not
            else if (choice == 7)
            {
                System.out.println("1st Fraction: Enter numerator");
                int firstNum = keyboard.nextInt();
                System.out.println("1st Fraction: Enter denominator");
                int firstDeno = keyboard.nextInt();
                Fraction frac1 = new Fraction(firstNum, firstDeno);
                System.out.println("2nd Fraction: Enter numerator");
                int secondNum = keyboard.nextInt();
                System.out.println("2nd Fraction: Enter denominator");
                int secondDeno = keyboard.nextInt();
                Fraction frac2 = new Fraction(secondNum, secondDeno);
                System.out.println(frac1.equal(frac1, frac2));
            }
            //If choice  = 8 turn fraction into decimal
            else
            {
                System.out.println("1st Fraction: Enter numerator");
                int firstNum = keyboard.nextInt();
                System.out.println("1st Fraction: Enter denominator");
                int firstDeno = keyboard.nextInt();
                Fraction frac1 = new Fraction(firstNum, firstDeno);
                System.out.print(frac1.decimal(frac1));
            }
            //Ask user want to cntinue or not
            System.out.print("\n\n");
            System.out.print("Press 0 to Quit\nPress 1 to do more calculation");
            choice1 = keyboard.nextInt();

        }while(choice1 != 0);


    }
}