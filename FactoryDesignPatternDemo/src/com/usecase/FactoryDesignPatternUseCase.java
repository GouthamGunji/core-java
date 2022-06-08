package com.usecase;

interface MyWrapper {
	void printType();
}

class MyInteger implements MyWrapper {
	public void printType() {
		System.out.println("The value is of type MyInteger");
	}
}

class MyDouble implements MyWrapper {
	public void printType() {
		System.out.println("The value is of type MyDouble");
	}
}

class MyBoolean implements MyWrapper {
	public void printType() {
		System.out.println("The value is of type MyBoolean");
	}
}

class MyCharacter implements MyWrapper {
	public void printType() {
		System.out.println("The value is of type MyCharacter");
	}
}

class MyWrapperFactory {
	public MyWrapper getMyWrapperInstance(String value) {
		// checking for MyInteger
		boolean notADigitFlag = false;
		for (int i = 0; i < value.length(); i++) {
			if (value.codePointAt(i) < 48 || value.codePointAt(i) > 57) {
				notADigitFlag = true;
				break;
			}
		}
		if (!notADigitFlag) {
			return new MyInteger();
		}

		// check for MyDouble
		boolean isADoubleFlag = false;
		for (int i = 0; i < value.length(); i++) {
			if (value.charAt(i) == '.' && i != 0 && (i != value.length() - 1)) {
				isADoubleFlag = true;
			}
		}

		if (isADoubleFlag) {
			return new MyDouble();
		}

		// check for MyBoolean
		if (value.equalsIgnoreCase("true") || value.equalsIgnoreCase("false")) {
			return new MyBoolean();
		}

		// check for MyCharacter
		if (value.length() == 1 && !(value.codePointAt(0) >= 48 && value.codePointAt(0) <= 57)) {
			return new MyCharacter();
		}

		// in case the value is not one of the four types
		throw new IllegalArgumentException("Value format not recognized");
	}
}

public class FactoryDesignPatternUseCase {
	public static void main(String[] args) {
		MyWrapperFactory factory = new MyWrapperFactory();

		MyWrapper obj = factory.getMyWrapperInstance("a");
		obj.printType();
	}
}