package me;

import me.Number_custom.baseType;

public class Initialize {
	public static void main(String[] args) {
		Number number_decimal = new Number_custom(36);
		Number number_octal = new Number_custom("232", baseType.OCTAL);
		Number number_base13 = new Number_custom("187", 13);
		Number number_hexadecimal = new Number_custom("FF", baseType.HEXADECIMAL);
		
		System.out.println(number_decimal.number + " is " + number_decimal.to_binary() + " in binary.");
		System.out.println(number_octal.number + "(base 8) is " + number_octal.to_decimal() + " in decimal.");
		System.out.println(number_base13.number + "(base 13) is " + number_base13.to_hexadecimal() + " in hexadecimal.");
		System.out.println(number_hexadecimal.number + "(base 16) is " + number_hexadecimal.to_custom_base(4) + " in base 4.");
	}
}
