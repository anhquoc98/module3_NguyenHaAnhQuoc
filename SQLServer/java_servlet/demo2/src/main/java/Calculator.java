public class Calculator {
    public static double calculator(double a,double b,String calcula){
        double result = 0;
        switch (calcula){
            case "+":
                result =a+b;
                break;
            case "-":
                result =a-b;
                break;
            case "*":
                result=a*b;
                break;
            case "/":
               try {
                   result=a/b;
               }catch (ArithmeticException c){
                   throw new RuntimeException();
               }
                break;
        }

        return result;
    }
}
