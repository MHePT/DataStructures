package data.structures;

public class ArrayQueue {
    
    int[] Arr;
    int Size,Front,Rear;

    public ArrayQueue(int Size) {
        this.Size = Size;
        Arr = new int[Size];
        Front = Rear = -1;
    }
    
    //Checks if Front and Rear Pointer equals to -1 
    boolean isEmpty(){
        return Front == -1 && Rear == -1;
    }
    
    //Checks if Rear Pointer Behind The Front
    boolean isFull(){
        return (Rear+1)%Size == Front;
    }
    
    /*Adds New Data To Rear of Queue
    Takes The New Data As an Input*/
    boolean Enqueue(int Data){
        //If The Queue NOT Full Do 
        if(!isFull()){
            //If The Queue Empty Do
            if(isEmpty()){
                /*Make Front and Rear Pointers Points to The Start of The Array
                (Start Position of The Queue)*/
                Front = Rear = 0;
                //Adds Data to The Start Postion
                Arr[0] = Data;
                //End Function and Return True As Output (Data Added)
                return true;
            }
            //If The Queue is not Empty Moves The Rear Pointer one Step
            Rear = (Rear+1)%Size;
            //Adds Data to New Rear Postion
            Arr[Rear] = Data;
            //End The Function and Return True As Output (Data Added)
            return true;
        }
        //End The Function and Return False (Error) As Output (Data Not Added)
        return false;
    }
    
    //Removes The Front Data in Queue
    int Dequeue(){
        //If The Queue NOT Empty Do
        if(!isEmpty()){
            
            //If There is only One element in Queue Do
            if(Rear == Front)
            {
                //Save The Front Pointer Postion To Variable To Not Loss The Position
                int x = Front;
                //Reintialize Front and Rear to the Unique Postion 
                Front = Rear = -1;
                //Ends The Function And Return The Data as an Output
                return Arr[x];
            }
            /*If There are More Than one element
            Save The Front Pointer Postion To Variable To Not Loss The Position*/
            int x = Front;
            //Moves The Front Pointer one Step Back
            Front = (Front+1)%Size;
            //Ends The Function And Return The Data as an Output
           return Arr[x]; 
        }
        //Ends The Function And Return -1 (Error) as an Output(Nothing Removed)
        return -1;
    }
}
