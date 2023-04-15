package data.structures;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Project1 {

    private static Stack<Character> stack;
    private static Stack<Double> stackCalc;
    private static String postfix = "";

    static String infix_postfix(String infix) {
        
        stack = new Stack<>();
        
        if(!isValid_Infix(infix))
            return "UnValid Expression";

        for (int i = 0; i < infix.length(); i++) {

            if (priority(infix.charAt(i)) != -1 && !stack.isEmpty()) {

                if (priority(infix.charAt(i)) > priority(stack.Peek()) || priority(infix.charAt(i)) == 0) {

                    if (infix.charAt(i) == ')') {

                        while (stack.Peek() != '(') 
                            postfix += stack.Pop();
                        

                        stack.Pop();

                    } else 

                        stack.Push(infix.charAt(i));

                    

                } else {

                    while (priority(infix.charAt(i)) <= priority(stack.Peek())) 
                        postfix += stack.Pop();
                    

                    stack.Push(infix.charAt(i));

                }

            } else if (priority(infix.charAt(i)) != -1 && stack.isEmpty())

                stack.Push(infix.charAt(i));

              else 

                postfix += infix.charAt(i);

            

        }

        while (!stack.isEmpty()) 
            if (priority(stack.Peek()) != 0) 
                postfix += stack.Pop();
            else 
                stack.Pop();
                
             
        return postfix;
            
        

    }
    
    static double postfix_value(String postfix){
        
        if(!isValid_Postfix(postfix))
            return 0.0;
        
        stackCalc = new Stack<>();
        
        for(int i = 0;i<postfix.length();i++)
        {
            if(isOperator(postfix.charAt(i))){
                
                if(postfix.charAt(i) == '^'){
                    
                    double right = stackCalc.Pop();
                    double left = stackCalc.Pop();
                    
                    stackCalc.Push(Math.pow(left, right));
                    
                }else if(postfix.charAt(i) == '*'){
                    
                    double right = stackCalc.Pop();
                    double left = stackCalc.Pop();
                    
                    stackCalc.Push(left*right);
                    
                }else if(postfix.charAt(i) == '/'){
                    
                    double right = stackCalc.Pop();
                    double left = stackCalc.Pop();
                    
                    stackCalc.Push(left/right);
                    
                }else if(postfix.charAt(i) == '+'){
                    
                    double right = stackCalc.Pop();
                    double left = stackCalc.Pop();
                    
                    stackCalc.Push(left+right);
                    
                }else if(postfix.charAt(i) == '-'){
                    
                    double right = stackCalc.Pop();
                    double left = stackCalc.Pop();
                    
                    stackCalc.Push(left-right);
                    
                }else
                    return 0;
                    
                    
            }else 
                stackCalc.Push(Double.parseDouble(""+postfix.charAt(i)));
        }
        
        return stackCalc.Pop();
    }

    private static int priority(char operator) {
        switch (operator) {
            case '^':
                return 3;
            case '*':
                return 2;
            case '/':
                return 2;
            case '+':
                return 1;
            case '-':
                return 1;
            case '(':
                return 0;
            case ')':
                return 0;
            default:
                return -1;
        }
    }
    
    private static boolean isValid_Infix(String infix){
        
        Pattern pattern = Pattern.compile("[a-zA-Z]");
        Matcher matcher = pattern.matcher(infix);
        
        return matcher.find();
    }
    
    private static boolean isValid_Postfix(String postfix){
        
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(postfix);
        
        return matcher.find();
    }
    
    private static boolean isOperator(char operator){
        switch (operator) {
            case '^':
            case '*':
            case '/':
            case '+':
            case '-':
                return true;
            default:
                return false;
        }
    }

}
