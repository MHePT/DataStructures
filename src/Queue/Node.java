package Queue;

//Class To Create Object to Store Data and Next Node To Make Linked List 
class Node<T> {
    
    T Data; //Variable to Store Data
    Node Next; //Pointer Points To Next Node
    
    Node(T Data){
        this.Data = Data;
        Next = null;
    }
    
}
