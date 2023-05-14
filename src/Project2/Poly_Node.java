package Project2;

public class Poly_Node {
    
    double Coefficient;
    double Exponent;
    Poly_Node Next;
    Poly_Node Previous;
    
    Poly_Node(double Coefficient, double Exponent) {
        this.Coefficient = Coefficient;
        this.Exponent = Exponent;
        Next = Previous =null;
    }
    
    
}
