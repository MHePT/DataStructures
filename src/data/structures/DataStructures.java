package data.structures;

public class DataStructures {

    public static void main(String[] args) {
        //Creating Linked Based Stack For Testing Purposes
        //test is an ID(identifier) of Object of user Defined Class LinkedStack 
      //LinkedStack test = new LinkedStack();

      //for (int i = 0; i < 5; i++) 
          //test.Push(i); // Filling Stack with values from 0 to 4
        

        //Dispaly Stack in Reverse Order Without Changing the Stack
      //Display_Reverse(test);

        //Asking if number 2 is in Stack
      //System.out.println(Search(test, 2)); // Prints true
            
      
      System.out.println(Project1.infix_postfix("(A/B*(C+(D-E))"));
      
      System.out.println(Project1.postfix_value("234+*"));
      
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

    //Searching Stack For Target Value
    //Takes Object From LinkedStack Class and Target Value to search As An Input
    static boolean Search(LinkedStack S, int Target) {

        /*Make a Pointer Run Through The Stack Without Manipulating(Playing with) 
        The Top Pointer in Stack*/
        Node<Integer> Runner = S.Top;

        //Do The Same Block of Code While the Stack is NOT Empty and Pointer Did NOT Reach The End
        while (!S.isEmpty() && Runner != null) {

            //If The Target Value Found in This Node End The Function And Return True As An Output
            if (Runner.Data == Target) 
                return true;
            

            //If Not Found in This Node Move The Pointer To Next Node
            Runner = Runner.Next;
        }
        //If The Target Value Not Found At All End The Function And Return False As An Output
        return false;
    }

    //Count The Size of Either Linked Based Stack or Queue
    //Takes Object From Node Class As an Input (Top Pointer in the Stack) 
    static int Size(Node TopNode) {

        //Intializing Counter
        int size = 0;

        /*Make a Pointer Run Through The Stack Without Manipulating(Playing with) 
        The Top Pointer in Stack*/
        Node Runner = TopNode;

        //Do The Same Block of Code While the Pointer Did NOT Reach The End
        while (Runner != null) {

            //Add 1 to the Counter
            size++;

            //Move The Pointer To Next Node
            Runner = Runner.Next;
        }

        //End The Function and Return the Counter As An Output
        return size;
    }

    //Count The Size of Either Linked Based Stack or Queue USING RECURSION
    //Takes Object From Node Class As an Input (Top Pointer in the Stack) 
    static int SizeRecursion(Node TopNode) {
        /*Make a Pointer Run Through The Stack Without Manipulating(Playing with) 
        The Top Pointer in Stack*/
        Node Runner = TopNode;

        //The Base Case
        //If The Runner Reached The End.Then,End The Function and return 0 as an Output 
        if (Runner == null) 
            return 0;
        


        /*If The Runner Did Not Reach The End.Then,End The Function After
        1.Calling Yourself again with Next Node As an Input (The Pointer of second calling
        points to next Node)
        2.Adding 1 to the output of the Second Calling and return it as Output
         */
        return 1 + SizeRecursion(Runner.Next);
    }

    //Insert New Node After the Searched Target Value in Linked Based Stack
    /*Takes 
    1.Object From Node Class (Top Pointer in the Stack) 
    2.Target Value to search
    3.New Node Required Value
    As an Input
     */
    static boolean InsertAfter(Node TopNode, int Target, int newNodeValue) {

        /*Make a Pointer Run Through The Stack Without Manipulating(Playing with) 
        The Top Pointer in Stack*/
        Node<Integer> Runner = TopNode;

        //Do The Same Block of Code While the Pointer Did NOT Reach The End
        while (Runner != null) {

            //If The pointed Node Have The Target Value Do this Block
            if (Runner.Data == Target) {

                //Creat The New Node With The Required Value
                Node newNode = new Node(newNodeValue);
                //Make The Next of New Node is The Next of Pointed Node
                newNode.Next = Runner.Next;
                //Make The Next of The Pointed is New Node
                Runner = newNode;
                //End The Function And Return True As An Output
                return true;
            }

            //Move The Pointer To Next Node
            Runner = Runner.Next;
        }

        //If The Target Value Not Found At All End The Function And Return False As An Output
        return false;
    }

    //Delete Last Node in Linked Based Stack
    //Takes Object From Node Class As an Input (Top Pointer in the Stack) 
    static boolean DeleteLastNode(Node TopNode) {

        //Checks if The Stack IS Not Already Empty
        if (TopNode != null) {
            /*Make a Pointer Run Through The Stack Without Manipulating(Playing with) 
            The Top Pointer in Stack*/
            Node BeforeLastNode = TopNode;

            //Do The Same Block of Code While the Pointer Did NOT Reach Before Last Node
            while (BeforeLastNode.Next.Next != null) 
                //Move The Pointer To Next Node
                BeforeLastNode = BeforeLastNode.Next;
            

            //Make The Before Last Node Next Points To Null Instead Of Last Node
            BeforeLastNode = null;
            //End The Function And Return True As An Output(Last Node Deleted)
            return true;
        }

        //If Empty End The Function And Return False As An Output(Last Node Not Deleted)
        return false;

    }

    boolean Compare_Lists(Node L1, Node L2) {

        Node Run1 = L1, Run2 = L2;

        if (Run1 == null && Run2 == null) 
            return true;
        

        if (Run1 == null || Run2 == null) 
            return false;
        

        while (Run1 == null && Run2 == null) {

            if (Run1.Data != Run2.Data) 
                return false;
            

            Run1 = Run1.Next;
            Run2 = Run2.Next;
        }

        return false;
    }

    boolean Compare_Lists_R(Node L1, Node L2) {

        if (L1 == null && L2 == null) 
            return true;
        
        if (L1 == null || L2 == null) 
            return false;
        
        if (L1.Data != L2.Data) 
            return false;
        

        return Compare_Lists_R(L1.Next, L2.Next);
    }

    LinkedStack Sort(LinkedStack S) {
        LinkedStack Temp = new LinkedStack();

        while (!S.isEmpty()) {
            int x = S.Pop();
            
            while (!Temp.isEmpty() && Temp.Peek() > x) 
                S.Push(Temp.Pop());
            
            Temp.Push(x);
        }

        return Temp;
    }

    void Calc(Node<Integer> L) {
        int counter = 0, sum = 0, max, min;
        double avg;
        max = min = L.Data;
        Node<Integer> t = L;
        while (t != null) {
            sum += t.Data;
            counter++;
            
            if (t.Data > max) 
                max = t.Data;
            
            if (t.Data < min) 
                max = t.Data;
            
            t = t.Next;
        }

        avg = sum / counter;
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
        System.out.println("Avg: " + avg);

    }

    void swap(Node first, Node second) {
        Node t1, t2, t3;
        t1 = t3 = first;
        
        while (t3.Next.Next != null) 
            t3 = t3.Next;
        
        t2 = t3.Next;
        t2.Next = t1.Next;
        t3.Next = t1;
        t1.Next = null;
        first = t1;
        second = t2;
    }

}
