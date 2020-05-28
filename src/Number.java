package me;
abstract public class Number {
	String number;

	public Number(String number) {
		setNumber(number);
	}

	public void setNumber(String number) {
		this.number = number;
	}
	public String getNumber() {
		return number;
	}

	public abstract String to_custom_base(int base);
	public abstract String to_binary(); 				//base 2
	public abstract String to_octal();					//base 8
	public abstract int to_decimal();					//base 10
	public abstract String to_hexadecimal();			//base 16
}
