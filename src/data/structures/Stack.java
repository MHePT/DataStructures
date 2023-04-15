package data.structures;

public class Stack <T> {

    private Node<T> Top = null;

    boolean isEmpty() {
        return Top == null;
    }

    
    boolean Push(T Data) {
        
        Node newNode = new Node(Data);
        newNode.Next = Top;
        Top = newNode;
        
        return true;
    }

    
    T Pop() {
        
        if (!isEmpty()) {
            
            T res = Top.Data;
            Top = Top.Next;
            return res;
            
        }
        
        return null;
    }

    
    T Peek() {
        
        if (!isEmpty()) 
            return Top.Data;
        
        return null;
    }
    

    int Size(){
        
        int size = 0;
        Node Runner = Top;
        
        while(Runner != null){
            
            size++;
            Runner = Runner.Next;
            
        }
        
        return size;
    }


    
}
