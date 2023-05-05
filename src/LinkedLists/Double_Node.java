package LinkedLists;

public class Double_Node<T> {
    
    T Data;
    Double_Node<T> Next;
    Double_Node<T> Previous;
    
    Double_Node(T Data){
        this.Data = Data;
        Next = Previous =null;
    }
    
}
