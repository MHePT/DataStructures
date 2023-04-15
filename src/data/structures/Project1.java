package data.structures;

import java.util.Stack;

public class Project1 {

    private static Stack<Character> stack = new Stack<>();
    private static String postfix = "";

    static void infix_postfix(String infix) {

        for (int i = 0; i < infix.length(); i++) {

            if (priority(infix.charAt(i)) != -1 && !stack.empty()) {

                if (priority(infix.charAt(i)) > priority(stack.peek()) || priority(infix.charAt(i)) == 0) {

                    if (infix.charAt(i) == ')') {

                        while (stack.peek() != '(') 
                            postfix += stack.pop();
                        

                        stack.pop();

                    } else 

                        stack.push(infix.charAt(i));

                    

                } else {

                    while (priority(infix.charAt(i)) <= priority(stack.peek())) 
                        postfix += stack.pop();
                    

                    stack.push(infix.charAt(i));

                }

            } else if (priority(infix.charAt(i)) != -1 && stack.empty())

                stack.push(infix.charAt(i));

              else 

                postfix += infix.charAt(i);

            

        }

        while (!stack.isEmpty()) 
            if (priority(stack.peek()) != 0) 
                postfix += stack.pop();
            else 
                stack.pop();
                
             
        System.out.println(postfix);
            
        

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
    
    private static boolean isValid(String infix){
        return false;
    }

}
