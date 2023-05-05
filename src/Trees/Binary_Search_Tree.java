package Trees;

public class Binary_Search_Tree<T extends Comparable> extends Binary_Tree<T> {
    
    public void Insert_BST(T Data)
    {
        Root = insertBST(Root, Data);
    }
    
    private Tree_Node insertBST(Tree_Node Root,T Data)
    {
        if(Root==null)
            return Root = new Tree_Node(Data);
        
        if(Data.compareTo(Root.Data) < 0)
            Root.Left = insertBST(Root.Left, Data);
        
        if(Data.compareTo(Root.Data) > 0)
            Root.Right = insertBST(Root.Right, Data);
        
        return Root;
    }
    
    public boolean Search(T Data){
        return Search(Root , Data);
    }
    
    private boolean Search(Tree_Node Root , T Data){
        
        if(Root == null && Data != null)
            return false;
        
        if(Data.compareTo(Root.Data) < 0)
            Search(Root.Left, Data);
        
        if(Data.compareTo(Root.Data) > 0)
            Search(Root.Right, Data);
        
        return true;
    }
    
}
