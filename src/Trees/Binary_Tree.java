package Trees;

public class Binary_Tree<T> {
    
    protected class Tree_Node<T> {
    
    T Data;
    Tree_Node<T> Left,Right;

    public Tree_Node(T Data) {
        this.Data = Data;
    }

    public Tree_Node(T Data, Tree_Node<T> Left, Tree_Node<T> Right) {
        this.Data = Data;
        this.Left = Left;
        this.Right = Right;
    }
    
    
    }
    
    protected Tree_Node<T> Root;

    public Binary_Tree() {
        Root = null;
    }
    
    public void Insert_Left(T Data){
        Root = Insert_Left(Root, Data);
    }
    
    private Tree_Node Insert_Left(Tree_Node<T> Root,T Data){
        if(Root == null)
           return Root = new Tree_Node<>(Data);
        
        Root.Left = Insert_Left(Root.Left,Data);
        
        return Root;
    }
    
    public void Insert_Right(T Data){
        Root = Insert_Right(Root, Data);
    }
    
    private Tree_Node Insert_Right(Tree_Node<T> Root,T Data){
        if(Root == null)
           return Root = new Tree_Node<>(Data);
        
        Root.Right = Insert_Right(Root.Left,Data);
        
        return Root;
    }
    
    public void Print_Preorder(){
        Print_Preorder(Root);
    }
    
    private void Print_Preorder(Tree_Node<T> Root){
        System.out.println(Root.Data);
        Print_Preorder(Root.Left);
        Print_Preorder(Root.Right);
    }
    
    public void Print_Inorder(){
        Print_Inorder(Root);
    }
    
    private void Print_Inorder(Tree_Node<T> Root){
        Print_Inorder(Root.Left);
        System.out.println(Root.Data);
        Print_Inorder(Root.Right);
    }
    
    public void Print_Postorder(){
        Print_Postorder(Root);
    }
    
    private void Print_Postorder(Tree_Node<T> Root){
        Print_Postorder(Root.Left);
        Print_Postorder(Root.Right);
        System.out.println(Root.Data);
    }
    
    public int Size(){
        return Size(Root);
    }
    
    private int Size(Tree_Node Root){
        if(Root == null)
            return 0;
        return Size(Root.Right) + 1 + Size(Root.Left);
    }
    
}
