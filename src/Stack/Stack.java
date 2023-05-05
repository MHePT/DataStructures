package Stack;

public class Stack <T> {

    private Node<T> Top = null;

    public boolean isEmpty() {
        return Top == null;
    }

    
    public boolean Push(T Data) {
        
        Node newNode = new Node(Data);
        newNode.Next = Top;
        Top = newNode;
        
        return true;
    }

    
    public T Pop() {
        
        if (!isEmpty()) {
            
            T res = Top.Data;
            Top = Top.Next;
            return res;
            
        }
        
        return null;
    }

    
    public T Peek() {
        
        if (!isEmpty()) 
            return Top.Data;
        
        return null;
    }
    

    public int Size(){
        
        int size = 0;
        Node Runner = Top;
        
        while(Runner != null){
            
            size++;
            Runner = Runner.Next;
            
        }
        
        return size;
    }


    
}
