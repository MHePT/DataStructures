package Queue;

public class LinkedQueue {
    
    Node<Integer> Front ,Rear;

    public LinkedQueue() {
        Front = Rear = null;
    }
    
    //Checks if Front and Rear Pointer equals to null (Nothing)
    boolean isEmpty(){
        return Front == null && Rear == null;
    }
    
    /*Adds New Data To Rear of Queue
    Takes The New Data As an Input*/
    boolean Enqueue(int Data){
        //Creates New Object From Node Named(Identified As) newNode With New Data
        Node newNode = new Node(Data);
        /*If the Object NOT Created Due To error (No Enough Memory Maybe) 
        End The Function And Return False (Error) as an Output(Data Not Added)*/
        if(newNode == null)
            return false;
        //If The Queue is Empty Do
        if(isEmpty()){
            //Make Front and Rear Points to The New Node
            Front = Rear = newNode;
            //End The Function And Return True as an Output(Data Added)
            return true;
        }
        //If The Queue Is Not Empty Make Last Node Points to The New Node
        Rear.Next = newNode;
        //Make Rear Pointer Point to The New Node
        Rear = newNode;
        //End The Function And Return True as an Output(Data Added)
        return true;
    }
    
    //Removes The Front Data in Queue
    int Dequeue(){
        /*If The Queue is Already Empty It will
        End The Function And Return -1 (Error) as an Output(Nothing Removed)*/
        if(isEmpty())
        return -1;
        //Saves The Front Data of Node Preventing From Loss
        int Data = Front.Data;
        //Moves Front Pointer One Step Back
        Front = Front.Next;
        //If the Queue Is Empty Reinitialize The Front And Rear Pointers
        if(Front == null)
            Rear = null;
        //End Function and Return The Data as an Output
        return Data;
    }
    
    //Count The Size of Either Linked Based Stack or Queue
    //Takes Object From Node Class As an Input (Top Pointer in the Stack) 
    public int Size() {

        //Intializing Counter
        int size = 0;

        /*Make a Pointer Run Through The Stack Without Manipulating(Playing with) 
        The Top Pointer in Stack*/
        Node<Integer> Runner = Front;

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
    
     //Insert New Node After the Searched Target Value in Linked Based Stack
    /*Takes 
    1.Object From Node Class (Top Pointer in the Stack) 
    2.Target Value to search
    3.New Node Required Value
    As an Input
     */
    public boolean InsertAfter(int Target, int newNodeValue) {

        /*Make a Pointer Run Through The Stack Without Manipulating(Playing with) 
        The Top Pointer in Stack*/
        Node<Integer> Runner = Front;

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
    
    public int SizeRecursion(){
        return SizeRecursion(Front);
    }
    
    //Count The Size of Either Linked Based Stack or Queue USING RECURSION
    //Takes Object From Node Class As an Input (Top Pointer in the Stack) 
    private int SizeRecursion(Node Front) {
        /*Make a Pointer Run Through The Stack Without Manipulating(Playing with) 
        The Top Pointer in Stack*/
        Node Runner = Front;

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
