
public class FractionTester 
{
	public static void main(String [] args)
	{
		Fraction g = new Fraction(-3,4);
		Fraction h = new Fraction(3);
		Fraction f = new Fraction("-1000/400");
		Fraction a = new Fraction(1,2);
		Fraction b = new Fraction(2,4);
		System.out.println(f.toString());
		System.out.println(g.toString());
		System.out.println(h.toString());
		System.out.println(f.getNumerator());
		System.out.println(g.getDenominator());
		g.simplify();
		System.out.println(g.toString());
		System.out.println(g.toDouble());
		f.fixSigns();
		System.out.println(f.toString());
		f.simplify();
		System.out.println(f.toPrettyString());
		System.out.println(f.getInverse());
		System.out.println(a.equivalentTo(b));
		System.out.println(g.add(h));
	}
	
} //end FractionTester
