package LinkedLists;

public class Double_LinkedList<T> {
    
    private Double_Node< T > First;
    private Double_Node< T > Last;
    String Name;

    Double_LinkedList(String Name) {
        this.Name = Name;
        First = Last = null;
    }
    
    boolean isEmpty(){
        return First == null && Last == null;
    }
    
    void Insert_At_Front(T newValue){
        
        Double_Node <T> newNode = new Double_Node(newValue);
        newNode.Next = First;
        First = newNode.Next.Previous = newNode;
        
        if(Last == null)
            Last = First;
        
    }
    
    void Insert_At_Back(T newValue){
        
        Double_Node <T> newNode = new Double_Node(newValue);
        Last.Next = newNode;
        newNode.Previous = Last;
        Last = Last.Next;
        
        if(First == null)
            First = Last;
        
    }
    
    T Remove_From_Front(){
        
        if(First == null)
            return null;
        
        T Result = First.Data;
        
        if(First == Last)
            First = Last = null;
        
        First = First.Next;
        
        return Result;
        
    }
    
    T Remove_From_Back(){
        
        if(Last == null)
            return null;
        
        T Result = Last.Data;
        
        if(First == Last)
            First = Last = null;
        
        Last = Last.Previous;
        Last.Next = Last.Next.Previous = null;
        
        return Result;
        
    }
    
    boolean InsertAfter(Double_Node TopNode, T Target, T newNodeValue) {

        Double_Node<T> Runner = TopNode;

        while (Runner != null) {

            if (Runner.Data == Target) {

                Double_Node<T> newNode = new Double_Node(newNodeValue);
                
                newNode.Next = Runner.Next;
                newNode.Next.Previous = newNode;
                newNode.Previous = Runner;
                Runner.Next = newNode;
                
                return true;
            }

            
            Runner = Runner.Next;
        }
        return false;
    }
    
    void Print(){
        Double_Node<T> Runner = First;
        
        while(Runner.Next != null)
        {
            System.out.println(Runner.Data);
            Runner = Runner.Next;
        }
    }

    T getFirst() {
        return First.Data;
    }

    T getLast() {
        return Last.Data;
    }

}


