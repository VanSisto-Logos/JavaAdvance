package com.vansisto;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Calculator calculator = new Calculator();
        calculator.sum(2, 3);
        calculator.sub(2, 3);
        calculator.mul(2, 3);
        calculator.div(2, 3);
    }
}
