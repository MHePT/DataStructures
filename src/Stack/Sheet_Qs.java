package Stack;

public class Sheet_Qs {
    
    public boolean Compare_Lists(Node L1, Node L2) {

        Node Run1 = L1, Run2 = L2;

        if (Run1 == null && Run2 == null) 
            return true;
        

        if (Run1 == null || Run2 == null)
            return false;
        

        while (Run1 == null && Run2 == null) {

            if (Run1.Data != Run2.Data) 
                return false;
            

            Run1 = Run1.Next;
            Run2 = Run2.Next;
        }

        return false;
    }

    public boolean Compare_Lists_R(Node L1, Node L2) {

        if (L1 == null && L2 == null) 
            return true;
        
        if (L1 == null || L2 == null) 
            return false;
        
        if (L1.Data != L2.Data) 
            return false;
        

        return Compare_Lists_R(L1.Next, L2.Next);
    }

    public LinkedStack Sort(LinkedStack S) {
        LinkedStack Temp = new LinkedStack();

        while (!S.isEmpty()) {
            int x = S.Pop();
            
            while (!Temp.isEmpty() && Temp.Peek() > x) 
                S.Push(Temp.Pop());
            
            Temp.Push(x);
        }

        return Temp;
    }

    public void Calc(Node<Integer> L) {
        int counter = 0, sum = 0, max, min;
        double avg;
        max = min = L.Data;
        Node<Integer> t = L;
        while (t != null) {
            sum += t.Data;
            counter++;
            
            if (t.Data > max) 
                max = t.Data;
            
            if (t.Data < min) 
                max = t.Data;
            
            t = t.Next;
        }

        avg = sum / counter;
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
        System.out.println("Avg: " + avg);

    }

    public void swap(Node first, Node second) {
        Node t1, t2, t3;
        t1 = t3 = first;
        
        while (t3.Next.Next != null) 
            t3 = t3.Next;
        
        t2 = t3.Next;
        t2.Next = t1.Next;
        t3.Next = t1;
        t1.Next = null;
        first = t1;
        second = t2;
    }
    
}
