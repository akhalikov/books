package chapter04.item15;

/**
 * Chapter 4: classes and interfaces
 * Item 15: Minimize mutability
 *
 * Immutable class
 */
public final class Complex {
  private final double re;
  private final double im;

  public Complex(double re, double im) {
    this.re = re;
    this.im = im;
  }

  // only accessors, no corresponding mutators
  public double realPart()      { return re; }
  public double imaginaryPart() { return im; }

  public Complex add(Complex c) {
    return new Complex(re + c.re, im + c.im);
  }

  public Complex substract(Complex c) {
    return new Complex(re - c.re, im - c.im);
  }

  public Complex multiply(Complex c) {
    double tmp = im * c.im;
    return new Complex(re * c.re - tmp, tmp - re * c.im);
  }

  public Complex divide(Complex c) {
    double tmp = c.re * c.re + c.im * c.im;
    return new Complex(
      (re * c.re + im * c.im) / tmp,
      (im * c.re - re * c.im) / tmp);
  }
}
