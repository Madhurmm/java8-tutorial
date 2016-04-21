package com.winterbe.java8.samples.lambda;

/**
 * @author Benjamin Winterberg
 */
public class Interface1 {

    interface Formula {
        double calculate(int a);

       /* 
        Default Methods for Interfaces

        Java 8 enables us to add non-abstract method implementations to interfaces by utilizing the 
        `default` keyword. This feature is also known as [virtual extension methods]
        (http://stackoverflow.com/a/24102730). 
        
        Keywords to look for : default
        	
        */
        
        default double sqrt(int a) {
            return Math.sqrt(positive(a));
        }

        static int positive(int a) {
            return a > 0 ? a : 0;
        }
    }

    public static void main(String[] args) {
        Formula formula1 = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };

        formula1.calculate(100);     // 100.0
        formula1.sqrt(-23);          // 0.0
        Formula.positive(-4);        // 0.0

//        Formula formula2 = (a) -> sqrt( a * 100);
        
        
       /* 
        The formula is implemented as an anonymous object. The code is quite verbose: 6 lines of 
        code for such a simple calculation of `sqrt(a * 100)`. As we'll see in the next section, 
        there's a much nicer way of implementing single method objects in Java 8.
        
         Keywords to look for : anonymous object
         
        */    
        
    }

}