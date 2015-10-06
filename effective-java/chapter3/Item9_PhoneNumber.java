import java.util.*;

final class PhoneNumber {
	private final short areaCode;
	private final short prefix;
	private final short lineNumber;

	public PhoneNumber(int areaCode, int prefix, int lineNumber) {
		rangeCheck(areaCode, 999, "area code");
		rangeCheck(prefix, 999, "prefix");
		rangeCheck(lineNumber, 9999, "line number");

		this.areaCode = (short) areaCode;
		this.prefix = (short) prefix;
		this.lineNumber = (short) lineNumber;
	}

	private static void rangeCheck(int arg, int max, String name) {
		if (arg < 0 || arg > max)
			throw new IllegalArgumentException(name + ": " + arg);
	}

	@Override public boolean equals(

		Object o) {
		if (o == this)
			return true;
		if (!(o instanceof PhoneNumber))
			return false;
		
		PhoneNumber pn = (PhoneNumber)o;
		return pn.lineNumber == lineNumber 
			&& pn.prefix == prefix 
			&& pn.areaCode == areaCode;
	}

	public static void main(String[] args) {
		System.out.println("Test of PhoneNumber without hashCode() being implemented");
		Map<PhoneNumber, String> m = new HashMap<PhoneNumber, String>();
		m.put(new PhoneNumber(707, 867, 5309), "Jenny");

		// prints null as hashCode is not implemented
		System.out.println("Result: " + m.get(new PhoneNumber(707, 867, 5309)));
	}
}