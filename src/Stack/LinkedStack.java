package Stack;

public class LinkedStack {

    public Node<Integer> Top = null;

    //Checks if Top points to Null (Nothing)
    public boolean isEmpty() {
        return Top == null;
    }

    /*Adds New Data To Stack
    Takes The New Data As an Input*/
    public boolean Push(int Data) {
        //Creates New Object From Node Named(Identified As) newNode With New Data
        Node newNode = new Node(Data);
        /*If the Object NOT Created Due To error (No Enough Memory Maybe) 
        End The Function And Return False (Error) as an Output(Data Not Added)*/
        if (newNode == null) 
            return false;
        //Make Next Pointer of New Node Points To Top 
        newNode.Next = Top;
        //Make Top Pointer Points To The New Node
        Top = newNode;
        //End The Function And Return True as an Output (Data Added)
        return true;
    }

    //Removes The Last Added Data
    public int Pop() {
        //If The Satck is NOT Empty Do
        if (!isEmpty()) {
            //Save The Top Node Data To Variable To Not Loss it
            int res = Top.Data;
            //Shifts The Top 1 Step Down 
            Top = Top.Next;
            //End The Function And Return The Data as an Output
            return res;
        }
        //End The Function And Return -1 (Error) as an Output(Nothing Removed)
        return -1;
    }

    //Returns The Data Of The Top
    public int Peek() {
        /*If The Satck is NOT Empty It will
        End The Function And Return The Data as an Output*/
        if (!isEmpty()) 
            return Top.Data;
        //End The Function And Return -1 (Error) as an Output(Stack is Empty)
        return -1;
    }
    
    //Searching Stack For Target Value
    //Takes Object From LinkedStack Class and Target Value to search As An Input
    public boolean Search(int Target) {

        /*Make a Pointer Run Through The Stack Without Manipulating(Playing with) 
        The Top Pointer in Stack*/
        Node<Integer> Runner = Top;

        //Do The Same Block of Code While the Stack is NOT Empty and Pointer Did NOT Reach The End
        while (!isEmpty() && Runner != null) {

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
    public int Size() {

        //Intializing Counter
        int size = 0;

        /*Make a Pointer Run Through The Stack Without Manipulating(Playing with) 
        The Top Pointer in Stack*/
        Node<Integer> Runner = Top;

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
    
    public boolean InsertAfter(int Target, int newNodeValue) {

        /*Make a Pointer Run Through The Stack Without Manipulating(Playing with) 
        The Top Pointer in Stack*/
        Node<Integer> Runner = Top;

        //Do The Same Block of Code While the Pointer Did NOT Reach The End
        while (Runner != null) {

            //If The pointed Node Have The Target Value Do this Block
            if (Runner.Data == Target) {

                //Creat The New Node With The Required Value
                Node newNode = new Node(newNodeValue);
                //Make The Next of New Node is The Next of Pointed Node
                newNode.Next = Runner.Next;
                //Make The Next of The Pointed is New Node
                Runner.Next = newNode;
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
    public boolean DeleteLastNode() {

        //Checks if The Stack IS Not Already Empty
        if (Top != null) {
            /*Make a Pointer Run Through The Stack Without Manipulating(Playing with) 
            The Top Pointer in Stack*/
            Node BeforeLastNode = Top;

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
    
    public int SizeRecursion(){
        return SizeRecursion(Top);
    }
    
    //Count The Size of Either Linked Based Stack or Queue USING RECURSION
    //Takes Object From Node Class As an Input (Top Pointer in the Stack) 
    private int SizeRecursion(Node Top) {
        /*Make a Pointer Run Through The Stack Without Manipulating(Playing with) 
        The Top Pointer in Stack*/
        Node Runner = Top;

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
}
