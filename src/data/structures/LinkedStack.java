package data.structures;

public class LinkedStack {

    Node Top = null;

    //Checks if Top points to Null (Nothing)
    boolean isEmpty() {
        return Top == null;
    }

    /*Adds New Data To Stack
    Takes The New Data As an Input*/
    boolean Push(int Data) {
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
    int Pop() {
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
    int Peek() {
        /*If The Satck is NOT Empty It will
        End The Function And Return The Data as an Output*/
        if (!isEmpty()) 
            return Top.Data;
        //End The Function And Return -1 (Error) as an Output(Stack is Empty)
        return -1;
    }
    
    //Comments of same function are in DataStructures.java
    int Size(){
        int size = 0;
        Node Runner = Top;
        while(Runner != null)
        {
            size++;
            Runner = Runner.Next;
        }
        return size;
    }
}
