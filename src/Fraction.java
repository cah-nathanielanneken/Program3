/**
 * Fraction class constructs a fraction and contains methods that return the
 * numerator or denominator of a fraction, calculate the division of the
 * numerator and the denominator, convert this fraction to a string, convert
 * this fraction to a prettier string, correctly simplify the signs in a
 * fraction, find the greatest common divisor of the numerator and the
 * denominator of this fraction, simplify the numerator and denominator, get the
 * inverse of this fraction, multiply this fraction with a given fraction,
 * divide this fraction with a given fraction, add this fraction with a given
 * fraction, subtract this fraction with a given fraction, and determine if this
 * fraction is equivalent to another fraction
 * 
 * @author Nathan Anneken
 * @version 1.2
 */
public class Fraction {
	private int numerator;
	private int denominator;

	/**
	 * Constructs a fraction given an integer numerator and an integer
	 * denominator
	 * 
	 * @param numerator
	 *            The numerator of the fraction
	 * @param denominator
	 *            The denominator of the fraction
	 */
	public Fraction(int numerator, int denominator) {
		if (denominator == 0) // checks denominator value
			throw new IllegalArgumentException("Invalid denominator");
		this.numerator = numerator;
		this.denominator = denominator;
	} // end Constructor

	/**
	 * Constructs a fraction with a given numerator, setting the denominator
	 * equal to one
	 * 
	 * @param numerator
	 *            The numerator of the fraction
	 */
	public Fraction(int numerator) {
		this(numerator, 1);
	} // end Constructor

	/**
	 * Constructs a fraction given a string
	 * 
	 * @param fractionString
	 *            A string representation of a fraction
	 */
	public Fraction(String fractionString) {
		int firstIntegerLength = 0;
		while (!fractionString.substring(firstIntegerLength,
				firstIntegerLength + 1).equals("/")) { // finds '/' place in the
														// string
			firstIntegerLength++;
		}
		this.numerator = Integer.valueOf(fractionString.substring(0,
				firstIntegerLength)); // Converts string numerator to an integer
										// and assigns value to numerator
		this.denominator = Integer.valueOf(fractionString
				.substring(firstIntegerLength + 1)); // Converts string
														// denominator to an
														// integer and assigns
														// value to denominator
		if (denominator == 0)
			throw new IllegalArgumentException("Invalid denominator");
	} // end Fraction

	/**
	 * Returns the numerator of this fraction
	 * 
	 * @return The numerator of this fraction
	 */
	public int getNumerator() {
		return this.numerator;
	} // end getNumerator

	/**
	 * Returns the denominator of this fraction
	 * 
	 * @return The denominator of this fraction
	 */
	public int getDenominator() {
		return this.denominator;
	} // end getDenominator

	/**
	 * Converts this fraction into a decimal
	 * 
	 * @return The decimal form of the fraction
	 */
	public double toDouble() {
		double doubleFraction = ((double) this.numerator)
				/ ((double) this.denominator);
		return doubleFraction;
	} // end doubleFraction

	/**
	 * Converts this fraction to a string
	 */
	public String toString() {
		String fraction = this.numerator + "/" + this.denominator;
		return fraction;
	} // end toString

	/**
	 * Converts this fraction to a more attractive string
	 * 
	 * @return A pretty looking string representation of this fraction
	 */
	public String toPrettyString() {
		int dashLength, tempValue;
		String dashes = "", emptySpaceNumerator = "", emptySpaceDenominator = "";
		if (Math.abs(this.numerator) >= Math.abs(this.denominator)) {
			dashLength = Integer.toString(this.numerator).length() + 2;
			emptySpaceNumerator = " ";
			int denominatorSpace = (Integer.toString(this.denominator).length()) / 2;
			while (denominatorSpace < (dashLength / 2)) {
				emptySpaceDenominator = emptySpaceDenominator + " ";
				denominatorSpace++;
			} // end while
		} else {
			dashLength = Integer.toString(this.denominator).length() + 2;
			emptySpaceDenominator = " ";
			int numeratorSpace = (Integer.toString(this.numerator).length()) / 2;
			while (numeratorSpace < (dashLength / 2)) {
				emptySpaceNumerator = emptySpaceNumerator + " ";
				numeratorSpace++;
			} // end while
		} // end if
		for (tempValue = 0; tempValue < dashLength; tempValue++)
			dashes = dashes + "-";
		String prettyString = emptySpaceNumerator + this.numerator + "\n"
				+ dashes + "\n" + emptySpaceDenominator + this.denominator;
		return prettyString;
	} // end toPrettyString

	/**
	 * Corrects the signs of the fraction and converts a fraction with a
	 * positive numerator and negative denominator into a negative numerator and
	 * a positive denominator
	 */
	public void fixSigns() {
		if (this.numerator < 0 && this.denominator < 0) {
			this.numerator = this.numerator * (-1);
			this.denominator = this.denominator * (-1);
		} else if (this.numerator > 0 && this.denominator < 0) {
			this.numerator = this.numerator * (-1);
			this.denominator = this.denominator * (-1);
		} // end if
	} // end FixSigns

	/**
	 * Finds the greatest common divisor of this numerator and this denominator
	 * 
	 * @return The greatest common divisor of this fraction
	 */
	private int gcd() {
		int tempDivisor, smallerInt, gcd = 0;
		if (Math.abs(this.numerator) <= Math.abs(this.denominator))
			smallerInt = Math.abs(this.numerator);
		else
			smallerInt = Math.abs(this.denominator);
		if (this.numerator == 0)
			return 0;
		else {
			for (tempDivisor = 1; tempDivisor <= smallerInt; tempDivisor++) {
				if (this.numerator % tempDivisor == 0
						&& this.denominator % tempDivisor == 0)
					gcd = tempDivisor;
			}// end for
			return gcd;
		}// end if
	} // end gcd

	/**
	 * Simplifies this fraction
	 */
	public void simplify() {
		int divisor = gcd();
		if (this.numerator != 0 && divisor != 0) {
			this.numerator = this.numerator / divisor;
			this.denominator = this.denominator / divisor;
		} // end if
		fixSigns();
	} // end simplify

	/**
	 * Finds the inverse of this fraction
	 * 
	 * @return The inverse fraction of this fraction
	 */
	public Fraction getInverse() {
		Fraction f = new Fraction(this.denominator, this.numerator);
		if (f.denominator == 0)
			throw new ArithmeticException("Invalid denominator");
		return f;
	} // end getInverse

	/**
	 * Multiplies this fraction with a given fraction
	 * 
	 * @param f1
	 *            A supplied fraction with which to multiply this fraction with
	 * @return The multiplied resultant fraction
	 */
	public Fraction multiply(Fraction f1) {
		Fraction f2 = new Fraction(this.numerator * f1.numerator,
				this.denominator * f1.denominator);
		f2.simplify();
		return f2;
	} // end multiply

	/**
	 * Divides this fraction with a given fraction
	 * 
	 * @param f1
	 *            A supplied fraction with which to divide this fraction with
	 * @return The resultant fraction after division
	 */
	public Fraction divide(Fraction f1) {
		if (f1.denominator == 0)
			throw new ArithmeticException("Invalide denominator");
		Fraction f2 = new Fraction(this.numerator * f1.denominator,
				this.denominator * f1.numerator);
		f2.simplify();
		return f2;
	} // end divide

	/**
	 * Adds this fraction with a given fraction
	 * 
	 * @param f1
	 *            A supplied fraction with which to add this fraction with
	 * @return The resultant fraction after addition
	 */
	public Fraction add(Fraction f1) {
		Fraction f2 = new Fraction((this.numerator * f1.denominator)
				+ (f1.numerator * this.denominator),
				(this.denominator * f1.denominator));
		f2.simplify();
		return f2;
	} // end add

	/**
	 * Subtracts this fraction with a given fraction
	 * 
	 * @param f1
	 *            A supplied fraction with which to subtract this fraction with
	 * @return The resultant fraction after subtraction
	 */
	public Fraction subtract(Fraction f1) {
		Fraction f2 = new Fraction((this.numerator * f1.denominator)
				- (f1.numerator * this.denominator),
				(this.denominator * f1.denominator));
		f2.simplify();
		return f2;
	} // end subtract

	/**
	 * Determines whether this fraction is equal to a supplied fraction
	 * 
	 * @param f1
	 *            A supplied fraction with which this fraction is compared to
	 * @return Boolean statement determining the equivalence of these two
	 *         fractions
	 */
	public boolean equivalentTo(Fraction f1) {
		f1.simplify();
		simplify();
		if (this.numerator == f1.numerator
				&& this.denominator == f1.denominator)
			return true;
		else
			return false;
	} // end equivalentTo
} // end Fraction
