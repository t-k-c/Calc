package tk.tkctechnologies.calc.calculator;

/**
 * Created by codename-tkc on 26/01/2018.
 */

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class StringManager {
    public static double evaluate(String expression) throws Exception{
        char[] tk = expression.toCharArray();
        System.out.println("Array: "+Arrays.toString(tk));
        Stack<Double> operands = new Stack<>();

        Stack<Character> operations = new Stack<>();

        for (int i = 0; i < tk.length; i++) {
//            System.out.println("stack content at  i="+i+" , Operands : "+operands.toString()+", Operations"+operations.toString());
            if (tk[i] == ' ')
                continue;

            if ((tk[i] >= '0' && tk[i] <= '9')  || tk[i]=='.') {
                StringBuffer sbuf = new StringBuffer();
                //     Log.i("hello",tk[i]+"is number");
                System.out.println(tk[i]+" is number");
                int j=i;
                while (j < tk.length && ((tk[j] >= '0' && tk[j] <= '9') || tk[j]=='.') )
                    sbuf.append(tk[j++]);
                i=j-1;
                operands.push(Double.parseDouble(sbuf.toString()));
            }


            else if (tk[i] == '(') {
                operations.push(tk[i]);
//                System.out.println(tk[i]+" is )");
            }

            else if (tk[i] == ')') {
//                System.out.println(tk[i]+" is (");
                //     Log.i("hello",operations.peek()+" is peek");
//                System.out.println(tk[i]+" is peek");

                while (operations.peek() != '(')
                    operands.push(applyOp(operations.pop(), operands.pop(), operands.pop()));
                operations.pop();
            }


            else if (tk[i] == '+' || tk[i] == '-' ||
                    tk[i] == '*' || tk[i] == '/') {
                //     Log.i("hello",tk[i]+" is operation");
//                System.out.println(tk[i]+" is operation");

                while (!operations.empty() && isPreceeded(tk[i], operations.peek()))
                    operands.push(applyOp(operations.pop(), operands.pop(), operands.pop()));


                operations.push(tk[i]);
            }
            System.out.println("i is "+i);
        }

        while (!operations.empty())
            operands.push(applyOp(operations.pop(), operands.pop(), operands.pop()));
        //     Log.i("hello",operations.toString()+"is operations and  "+operands.toString()+" is operand");
//        System.out.println(operations.toString()+"is operations and  "+operands.toString()+" is operand");

        return operands.pop();
    }


    public static boolean isPreceeded(char op1, char op2) {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

    public static double applyOp(char op, double b, double a) {
        //     Log.i("hello",op+";"+b+";"+a);
//        System.out.println(op+";"+b+";"+a);
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new
                            UnsupportedOperationException("Cannot divide by zero");
                return a / b;
        }
        return 0;
    }

}
