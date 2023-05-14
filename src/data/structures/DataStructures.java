package data.structures;

import Project2.Polynomial;
import Stack.LinkedStack;

public class DataStructures {

    public static void main(String[] args) {
        
        //Test_LinkedList();
        //Test_Project1();
        //Test_Tree();
        Test_Project2();
      
    }
    

    //Dispaly Stack in Reverse Order Without Changing the Stack
    //Takes Object From LinkedStack Class As An Input
    static void Display_Reverse(LinkedStack S) {
        //Creating Temporary Stack To Save Existing Stack to it After Printing
        LinkedStack Temp = new LinkedStack();

        //Do The Same Block of Code While the original Stack is NOT Empty
        while (!S.isEmpty()) {
            //Saving The Value to Variable Preventing From Loss
            int d = S.Pop();
            //Printing The Value
            System.out.println(d);
            //Pushing The Value To The Temporary Stack
            Temp.Push(d);
        }
        /*Do The Same Block of Code While the Temporary Stack is NOT Empty
        Take The Value in Temporary Stack and Return it to The Original Stack*/
        while (!Temp.isEmpty()) 
            S.Push(Temp.Pop());
        
    }
    
    static void Test_LinkedList(){
        //Creating Linked Based Stack For Testing Purposes
        //test is an ID(identifier) of Object of user Defined Class LinkedStack 
        LinkedStack test = new LinkedStack();

        for (int i = 0; i < 5; i++) 
            test.Push(i); // Filling Stack with values from 0 to 4
        

        //Dispaly Stack in Reverse Order Without Changing the Stack
        Display_Reverse(test);

        //Asking if number 2 is in Stack
        System.out.println(test.Search(2)); // Prints true
    }
    
    static void Test_Project1(){
        
        String s = Project1.infix_postfix("3*(4+5)-6/(1+2)");
        System.out.println(s);
        System.out.println(Project1.postfix_value(s));
        
    }
    
    static void Test_Project2(){
        
        Polynomial p1 = new Polynomial();
        p1.Insert(2, 3);
        p1.Insert(2, 0);
        p1.Insert(2, 2);
        
        p1.Display();
        
        System.out.println("***********************************************");
        
        Polynomial p2 = new Polynomial();
        p2.Insert(2, 3);
        p2.Insert(2, 0);
        p2.Insert(2, 2);
        
        p2.Display();
        
        System.out.println("***********************************************");
        
        (p1.Plus(p2)).Display();
                
        System.out.println("***********************************************");
        
        (p1.Minus(p2)).Display();
                
        System.out.println("***********************************************");
        
        (p1.Times(p2)).Display();
        
        System.out.println("***********************************************");
        
        System.out.println(p1.Evaluate(2));
        
    }
    
    static void Test_Tree(){
        
    }

}
