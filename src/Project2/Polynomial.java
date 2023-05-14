package Project2;

public class Polynomial {

    private Poly_Node First;
    private Poly_Node Last;
    private double Degree;

    public Polynomial() {
        Degree = 0;
        First = Last = null;
    }
    
    public double Evaluate(double x){
        double ret = 0;
        Poly_Node Runner = First;
        while(Runner != null){
            ret += Runner.Coefficient*Math.pow(x, Runner.Exponent);
            Runner = Runner.Next;
        }
        return ret;
    }
    
    public Polynomial Times(Polynomial p){
        
        Poly_Node Runner1 = p.getFirst();
        Polynomial ret = new Polynomial();
        
        while(Runner1!=null)
        {
            Poly_Node Runner2 = First;
            while(Runner2!=null){
                ret.Insert(Runner1.Coefficient*Runner2.Coefficient, Runner2.Exponent+Runner1.Exponent);
                Runner2 = Runner2.Next;
            }
            Runner1 = Runner1.Next;
        }
        
        
        return ret;
    }

    public Polynomial Plus(Polynomial p) {

        Poly_Node Runner1 = p.getFirst();
        Poly_Node Runner2 = First;
        Polynomial ret = new Polynomial();

        while (Runner1 != null && Runner2 != null) {
            if (Runner1.Exponent == Runner2.Exponent) {
                ret.Insert(Runner1.Coefficient + Runner2.Coefficient, Runner1.Exponent);
                Runner1 = Runner1.Next;
                Runner2 = Runner2.Next;
            } else if (Runner1.Exponent > Runner2.Exponent) {
                ret.Insert(Runner1.Coefficient, Runner1.Exponent);
                Runner1 = Runner1.Next;
            } else if (Runner1.Exponent < Runner2.Exponent) {
                ret.Insert(Runner2.Coefficient, Runner2.Exponent);
                Runner2 = Runner2.Next;
            }

        }
        while (Runner1 != null) {
            ret.Insert(Runner1.Coefficient, Runner1.Exponent);
        }
        while (Runner2 != null) {
            ret.Insert(Runner2.Coefficient, Runner2.Exponent);
        }

        return ret;

    }

    public Polynomial Minus(Polynomial p) {

        Poly_Node Runner2 = p.getFirst();
        Poly_Node Runner1 = First;
        Polynomial ret = new Polynomial();

        while (Runner1 != null && Runner2 != null) {
            if (Runner1.Exponent == Runner2.Exponent) {
                ret.Insert(Runner1.Coefficient - Runner2.Coefficient, Runner1.Exponent);
                Runner1 = Runner1.Next;
                Runner2 = Runner2.Next;
            } else if (Runner1.Exponent > Runner2.Exponent) {
                ret.Insert(Runner1.Coefficient, Runner1.Exponent);
                Runner1 = Runner1.Next;
            } else if (Runner1.Exponent < Runner2.Exponent) {
                ret.Insert(Runner2.Coefficient, Runner2.Exponent);
                Runner2 = Runner2.Next;
            }

        }
        while (Runner1 != null) {
            ret.Insert(Runner1.Coefficient, Runner1.Exponent);
        }
        while (Runner2 != null) {
            ret.Insert(Runner2.Coefficient, Runner2.Exponent);
        }

        return ret;

    }

    public boolean isEmpty() {
        return First == null && Last == null;
    }

    public void Insert(double Coefficient, double Exponent) {

        Poly_Node Runner = First;

        while (Runner != null) {

            if (Runner.Exponent == Exponent) {

                Runner.Coefficient += Coefficient;

                return;

            } else if (Runner.Exponent < Exponent) {

                Poly_Node newNode = new Poly_Node(Coefficient, Exponent);

                newNode.Next = Runner;
                if (Runner.Previous != null) {
                    Runner.Previous.Next = newNode;
                }
                newNode.Previous = Runner.Previous;
                Runner.Previous = newNode;

                while (First.Previous != null) {
                    First = First.Previous;
                    Degree = First.Exponent;
                }

                return;
            } else if (Runner.Exponent > Exponent && Runner.Next == null) {

                Poly_Node newNode = new Poly_Node(Coefficient, Exponent);

                newNode.Next = Runner.Next;
                if (newNode.Next != null) {
                    newNode.Next.Previous = newNode;
                }
                newNode.Previous = Runner;
                Runner.Next = newNode;

                return;
            }

            Runner = Runner.Next;
        }

        First = new Poly_Node(Coefficient, Exponent);
        Degree = Exponent;

        if (Last == null) {
            Last = First;
        }

    }

    public void Display() {

        Poly_Node Runner = First;

        while (Runner != null) {
            System.out.println(Runner.Coefficient + "x^" + Runner.Exponent);
            Runner = Runner.Next;
        }

    }

    public Poly_Node getFirst() {
        return First;
    }

    public Poly_Node getLast() {
        return Last;
    }

}
