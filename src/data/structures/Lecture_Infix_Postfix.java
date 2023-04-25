package data.structures;

import java.util.Stack;

public class Lecture_Infix_Postfix {

    private static Stack<Character> stack;
    private static Stack<Integer> valueStack;
    private static String postfix;

    boolean checkBalance(String expression) {

        stack = new Stack<>();

        boolean isBalanced = true;

        int index = 0;
        while (isBalanced && index < expression.length()) {
            char current_Char = expression.charAt(index++);

            switch (current_Char) {
                case '(':
                case '[':
                case '{':
                    stack.push(current_Char);
                    break;
                case ')':
                case ']':
                case '}':
                    if (stack.isEmpty()) {
                        isBalanced = false;
                    } else {
                        char openDelimiter = stack.pop();
                        isBalanced = current_Char == openDelimiter;
                    }
                    break;
                default:
                    break;
            }

        }

        if (!stack.isEmpty()) 
            isBalanced = false;
        
        return isBalanced;
    }

    String converToPostfic(String infix) {
        stack = new Stack<>();
        postfix = "";

        int index = 0;
        while (index < infix.length()) {
            
            char nextCharacter = infix.charAt(index);
            
            if (nextCharacter != ' ') {
                
                switch (nextCharacter) {
                    
                    case '^':
                        stack.push(nextCharacter);
                        break;
                    case '+':case '-':case '/':
                        while(!stack.isEmpty() && percedence(nextCharacter) <= stack.peek())
                            postfix += "" + stack.pop();
                        stack.push(nextCharacter);
                        break;
                    case '(':
                        stack.push(nextCharacter);
                    case ')':
                        char topOperator = stack.pop();
                        while(topOperator != '('){
                            postfix += "" + topOperator;
                            topOperator = stack.pop();
                        }
                        break;
                    default:
                        if(nextCharacter<'A' && nextCharacter>'Z' || nextCharacter<'a' && nextCharacter>'z')
                            postfix += "" + nextCharacter;
                        break;
                }
            } 
        }
        
        while(!stack.isEmpty())
        {
            char topOperator = stack.pop();
            postfix += "" + topOperator;
        }

        return postfix;
    }
    
    int evaluatePostfix(String postfix){
        
        valueStack = new Stack<>();
        
        int index = 0;
        while(index < postfix.length()){
            char nextCharacter = postfix.charAt(index);
            int operandTwo;
            int operandOne;
            int result;
            
            switch (nextCharacter) {
                case '^':
                    operandTwo = valueStack.pop();
                    operandOne = valueStack.pop();
                    result = (int)Math.pow(operandOne, operandTwo);
                    valueStack.push(result);
                    break;
                    
                case '*':
                    operandTwo = valueStack.pop();
                    operandOne = valueStack.pop();
                    result = operandOne*operandTwo;
                    valueStack.push(result);
                    break;
                    
                case '/':
                    operandTwo = valueStack.pop();
                    operandOne = valueStack.pop();
                    result = operandOne/operandTwo;
                    valueStack.push(result);
                    break;
                    
                case '+':
                    operandTwo = valueStack.pop();
                    operandOne = valueStack.pop();
                    result = operandOne+operandTwo;
                    valueStack.push(result);
                    break;
                    
                case '-':
                    operandTwo = valueStack.pop();
                    operandOne = valueStack.pop();
                    result = operandOne-operandTwo;
                    valueStack.push(result);
                    break;
                    
                default:
                    if(nextCharacter<'A' && nextCharacter>'Z' || nextCharacter<'a' && nextCharacter>'z')
                            postfix += "" + nextCharacter;
                        break;
            }
        }
        
        return valueStack.peek();
    }

    private static int percedence(char operator) {
        return switch (operator) {
            case '^' -> 3;
            case '*' -> 2;
            case '/' -> 2;
            case '+' -> 1;
            case '-' -> 1;
            case '(' -> 0;
            case ')' -> 0;
            default -> -1;
        };
    }
    
}
