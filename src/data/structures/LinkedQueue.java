
package data.structures;

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
    
    //Comments of same function are in DataStructures.java
    int Size(){
        int size = 0;
        Node Runner = Front;
        while(Runner != null)
        {
            size++;
            Runner = Runner.Next;
        }
        return size;
    }
    
    
}
