package me;
public final class Number_custom extends Number{
	int base;
	
	public static enum baseType{
		BINARY (2), OCTAL(8), DECIMAL(10), HEXADECIMAL(16);
		int customBase;
		baseType(int customBase){
			this.customBase = customBase;
		}
	}
	
	// Constructor for base argument as Enum
	public Number_custom(String number, baseType custom_base) {
		super(number);

		set_base(custom_base.customBase);
	}
	
	// Constructor for base argument as int
	public Number_custom(String num, int base) {
		super(num);
		
		set_base(base);
	}
	
	// Constructor for base 10
	public Number_custom(int number) {
		super(String.valueOf(number));
		
		set_base(10);
	}
	
	void set_base(int base) {
		if (base >= 2 && base <= 16) {
			this.base = base;
			} else {
			System.out.println("Base has to be at least 2 and max 16");
			this.base = 2;
		}
	}

	public String to_custom_base(int base) {
		if (base > 16 || base < 2) {
			System.out.println("Base has to be at least 2 and max 16");
			return "0";
		}
		
		String answer = "";
		// Converts the number to Decimal
		String decimal = Integer.toString(to_decimal());
		
		int remaining_num = Integer.valueOf(decimal);
		
		while(remaining_num>0) {
			String quotient = Integer.toString(remaining_num%base);
			

			if(Integer.parseInt(quotient) >= 10) {
				if(quotient.equals("10"))
					quotient="A";
				if(quotient.equals("11"))
					quotient="B";
				if(quotient.equals("12"))
					quotient="C";
				if(quotient.equals("13"))
					quotient="D";
				if(quotient.equals("14"))
					quotient="E";
				if(quotient.equals("15"))
					quotient="F";
				if(quotient.equals("16"))
					quotient="G";
			}
			
			answer = quotient + answer;
			
			remaining_num = remaining_num / base;
		}
		
		return answer;
	}
	
	@Override
	public int to_decimal() {
		int answer = 0;
		for(int letter_num = 0; letter_num < this.number.length(); letter_num++) {
			char current_letter = this.number.charAt(letter_num);
			int current_letter_int = Character.getNumericValue(current_letter);
		
			int power = this.number.length() - letter_num - 1;
			answer += current_letter_int * Math.pow(this.base, power);
		}
		return answer; 
	}
	
	@Override
	public String to_binary() {
		return to_custom_base(2);
	}

	@Override
	public String to_octal() {
		return to_custom_base(8);
	}

	@Override
	public String to_hexadecimal() {
		return to_custom_base(16);
	}
}
