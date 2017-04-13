/**
 * This class holds data values for numerator and denominator that the user enters, and performs operations
 * for each value as a fraction.
 *
 * @author Phat Pham and Lily Naoudom <ppham5@uncc.edu>
 * @version 2015/07/7/15/2015
 */
import java.util.*;
public class Fraction
{
    Fraction finalFraction;
    static Fraction finalFraction1;
    private int numerator;
    private int denominator;

    /**
     * This is a default constructor that sets each field value to 0.
     */
    public Fraction()
    {
        numerator = 0;
        denominator = 0;
    }

    /**
     * This is a overloaded constructor method that sets the value for each field.
     * @param num: value for numerator
     * @param deno: value for denominator
     */
    public Fraction(int num, int deno)
    {
        this.numerator = num;
        this.denominator = deno;
    }

    /**
     * This method adds the first fraction to the second fraction.
     * @param first: value for first fraction
     * @param second: value for second fraction
     * @return finalFraction: sum of first and second fraction
     */
    public Fraction add(Fraction first, Fraction second)
    {
        if (first.denominator == second.denominator) //if denominators are the same,
        {
            int temp = first.numerator + second.numerator;	//add first and second numerators
            finalFraction = new Fraction(temp, denominator); //new frac = temp/den
        }
        else	//if denominators are different,
        {
            int newDenominator = first.denominator * second.denominator; //multiply denominators
            int newFirstNum = first.numerator * second.denominator; 	 //multiply first num with second deno to get new num
            int newSecondNum = second.numerator * first.denominator;	 //multiply second num with first deno to get new num
            int addedNum = newFirstNum + newSecondNum;					 //add the two new numerators
            finalFraction = new Fraction(addedNum, newDenominator);		 //new frac = sum of new nums/product of new den
        }
        Reduce();	//simplify the answer before returning
        return finalFraction;
    }

    /**
     * This method subtracts the first and second fraction.
     * @param first: value for first fraction
     * @param second: value for second fraction
     * @return finalFraction: difference of first and second fraction
     */
    public Fraction sub(Fraction first, Fraction second)
    {
        //check if they have the same denominator or not
        if (first.denominator == second.denominator)
        {
            int temp = Math.abs(first.numerator + second.numerator);
            finalFraction = new Fraction(temp, denominator);
        }
        else
        {
            int newDenominator = first.denominator * second.denominator;
            int newFirstNum = first.numerator * second.denominator;
            int newSecondNum = second.numerator * first.denominator;
            int addedNum = Math.abs(newFirstNum - newSecondNum);
            finalFraction = new Fraction(addedNum, newDenominator);
        }
        Reduce();
        return finalFraction;
    }

    /**
     * This method multiplies the first and second fraction.
     * @param first: value for first fraction
     * @param second: value for second fraction
     * @return finalFraction: product of first and second fraction
     */
    public Fraction multiply(Fraction first, Fraction second)
    {
        int newDenominator = first.denominator * second.denominator;
        int newNumerator = first.numerator * second.numerator;
        finalFraction = new Fraction(newNumerator, newDenominator);
        Reduce();
        return finalFraction;
    }

    /**
     * This method divides the first and second fraction.
     * @param first: value for first fraction
     * @param second: value for second fraction
     * @return finalFraction: quotient of first and second fraction
     */
    public Fraction division(Fraction first, Fraction second)
    {
        int newNumerator = first.numerator * second.denominator;
        int newDenominator = first.denominator * second.numerator;
        finalFraction = new Fraction(newNumerator, newDenominator);
        Reduce();
        return finalFraction;
    }

    /**
     * This method compares the first and second fraction.
     * @param first: value for first fraction
     * @param second: value for second fraction
     * @return int: value that determines whether first fraction is greater than, less than, or equal to
     * the second fraction.
     */
    public int compareTo(Fraction first, Fraction second)
    {
        double frac1 = (double)first.numerator/(double)first.denominator;
        double frac2 = (double)second.numerator/(double)second.denominator;
        if (frac1 > frac2)
            return 1;
        else if (frac1 < frac2)
            return -1;
        else
            return 0;
    }

    /**
     * This method generates a random number for the numerator and denominator of a fraction.
     * @return finalFraction1: new randomly generated fraction
     */
    public static Fraction random()
    {
        Random rand = new Random();
        int newNumerator = rand.nextInt(10)+1;
        int newDenominator = rand.nextInt(10)+10;
        finalFraction1 = new Fraction(newNumerator, newDenominator);
        Reduce1();
        return finalFraction1;
    }

    /**
     * This method determines whether the first and second fractions are equal in value.
     * @param first: value for first fraction
     * @param second: value for second fraction
     * @return answer: boolean value for whether the two fractions are equal
     */
    public boolean equal(Fraction first, Fraction second)
    {
        boolean answer;
        double frac1 = (double)first.numerator/(double)first.denominator;
        double frac2 = (double)second.numerator/(double)second.denominator;
        if (frac1 == frac2)
            answer = true;
        else
            answer = false;
        return answer;
    }

    /**
     * This method converts a fraction into decimal form.
     * @param first: value for first fraction to be converted
     * @return frac1: decimal form of first fraction
     */
    public double decimal(Fraction first)
    {
        double frac1 = (double)first.numerator/(double)first.denominator;

        return frac1;
    }

    /**
     * This method simplifies the fraction.
     */
    private void Reduce()
    {
        //check if the numerator can divide and simplifies the denominator
        if (finalFraction.numerator % finalFraction.denominator == 0)
        {
            int newNum = finalFraction.numerator / finalFraction.denominator;
            int newDen = finalFraction.denominator / finalFraction.denominator;
            finalFraction.numerator = newNum;
            finalFraction.denominator = newDen;
        }
        //check if the denominator can divide and simplifies the nominator
        if (finalFraction.denominator % finalFraction.numerator == 0)
        {
            int newNum = finalFraction.numerator / finalFraction.numerator;
            int newDen = finalFraction.denominator / finalFraction.numerator;
            finalFraction.numerator = newNum;
            finalFraction.denominator = newDen;
        }
        //check if the nominator and denominator can divide by 3 and simplifies
        while (finalFraction.numerator % 3 == 0 && finalFraction.denominator % 3 == 0)
        {
            int newNum = finalFraction.numerator / 3;
            int newDen = finalFraction.denominator / 3;
            finalFraction.numerator = newNum;
            finalFraction.denominator = newDen;
        }
        //check if the nominator and denominator can divide by 2 and simplifies
        while (finalFraction.numerator % 2 == 0 && finalFraction.denominator % 2 == 0)
        {
            int newNum = finalFraction.numerator / 2;
            int newDen = finalFraction.denominator / 2;
            finalFraction.numerator = newNum;
            finalFraction.denominator = newDen;
        }
        //check if the nominator and denominator can divide by 5 and simplifies
        while (finalFraction.numerator % 5 == 0 && finalFraction.denominator % 5 == 0)
        {
            int newNum = finalFraction1.numerator / 5;
            int newDen = finalFraction1.denominator / 5;
            finalFraction.numerator = newNum;
            finalFraction.denominator = newDen;
        }
    }

    /**
     * This method simplifies the fraction for the static method.
     */
    private static void Reduce1()
    {
        //check if the numerator can divide and simplifies the denominator
        if (finalFraction1.numerator % finalFraction1.denominator == 0)
        {
            int newNum = finalFraction1.numerator / finalFraction1.denominator;
            int newDen = finalFraction1.denominator / finalFraction1.denominator;
            finalFraction1.numerator = newNum;
            finalFraction1.denominator = newDen;
        }
        //check if the denominator can divide and simplifies the nominator
        if (finalFraction1.denominator % finalFraction1.numerator == 0)
        {
            int newNum = finalFraction1.denominator / finalFraction1.numerator;
            int newDen = finalFraction1.numerator / finalFraction1.numerator;
            finalFraction1.numerator = newNum;
            finalFraction1.denominator = newDen;
        }
        //check if the nominator and denominator can divide by 3 and simplifies
        while (finalFraction1.numerator % 3 == 0 && finalFraction1.denominator % 3 == 0)
        {
            int newNum = finalFraction1.numerator / 3;
            int newDen = finalFraction1.denominator / 3;
            finalFraction1.numerator = newNum;
            finalFraction1.denominator = newDen;
        }
        //check if the nominator and denominator can divide by 2 and simplifies
        while (finalFraction1.numerator % 2 == 0 && finalFraction1.denominator % 2 == 0)
        {
            int newNum = finalFraction1.numerator / 2;
            int newDen = finalFraction1.denominator / 2;
            finalFraction1.numerator = newNum;
            finalFraction1.denominator = newDen;
        }
        //check if the nominator and denominator can divide by 5 and simplifies
        while (finalFraction1.numerator % 5 == 0 && finalFraction1.denominator % 5 == 0)
        {
            int newNum = finalFraction1.numerator / 5;
            int newDen = finalFraction1.denominator / 5;
            finalFraction1.numerator = newNum;
            finalFraction1.denominator = newDen;
        }
    }

    /**
     * This method returns the current field values for numerator and denominator.
     * @return String: current value for numerator and denominator
     */
    public String toString()
    {
        return numerator+"/"+denominator;
    }
}