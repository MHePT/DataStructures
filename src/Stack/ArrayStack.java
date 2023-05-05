package Stack;

public class ArrayStack {
    
    int[] Arr;
    int Top;
    int Size;
    
    ArrayStack(int Size){
        this.Size = Size;
        Arr = new int[Size];
        Top = -1;
    }
    
    //Checks if The Top pointer is equal -1
    boolean isEmpty(){
        return Top == -1;
    }
    
    //Checks if The Top is at last index of Array
    boolean isFull(){
        return Top == Size-1;
    }
    
    /*Adds New Data To Stack
    Takes The New Data As an Input*/
    boolean Push(int Data){
        //If The Satck is NOT Empty Do
        if(!isFull()){
            /* ++Top Add 1 to the variable First Then Uses The New Value
            Adds The New Data To The New Postion*/
            Arr[++Top]=Data;
            //End The Function And Return True as an Output(Data Added)
            return true;
        }
        //End The Function and Return False As Output (Data Not Added)
        return false;
    }
    
    //Removes The Last Added Data
    int Pop(){
        /*
        If The Satck is NOT Empty It will
        1.Uses The Value in the Top Variable And Gets The Data In Given Postion (Top)
        2.Decrease The Top with 1
        3.End The Function and Return The Data As Output
        */
        if(!isEmpty())
            return Arr[Top--];
        
        //End The Function and Return -1 (Error) As Output (Data Not Removed)
        return -1;
    }
    
    int Peek() {
        /*If The Satck is NOT Empty It will
        End The Function And Return The Data as an Output*/
        if (!isEmpty()) 
            return Arr[Top];
        //End The Function And Return -1 (Error) as an Output(Stack is Empty)
        return -1;
    }
}
