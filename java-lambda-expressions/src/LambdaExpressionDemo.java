interface Animal {
	void makeSound();
}

class Dog implements Animal {

	@Override
	public void makeSound() {
		// TODO Auto-generated method stub
		System.out.println("Bow Bow");
	}

}

class Cat implements Animal {

	@Override
	public void makeSound() {
		// TODO Auto-generated method stub
		System.out.println("Meow Meow");
	}

}

class Lion implements Animal {

	@Override
	public void makeSound() {
		// TODO Auto-generated method stub
		System.out.println("Roar");
	}

}

public class LambdaExpressionDemo {

	public static void main(String[] args) {
		// traditional implementation
		Animal dog = new Dog();
		dog.makeSound();

		Animal cat = new Cat();
		cat.makeSound();

		Animal lion = new Lion();
		lion.makeSound();

		// using Anonymous class
		Animal anonymousDog = new Animal() {
			@Override
			public void makeSound() {
				System.out.println("Bow Bow");
			}

		};		
		anonymousDog.makeSound();

		Animal anonymousCat = new Animal() {
			@Override
			public void makeSound() {
				System.out.println("Meow Meow");
			}

		};		
		anonymousCat.makeSound();

		Animal anonymousLion = new Animal() {
			@Override
			public void makeSound() {
				System.out.println("Roar");
			}

		};
		anonymousLion.makeSound();
		

		// using Lambda Expression
		Animal lambdaDog = () -> {
			System.out.println("Bow Bow");

		};
		lambdaDog.makeSound();
		
		Animal lambdaCat = () -> {
			System.out.println("Meow Meow");

		};
		lambdaCat.makeSound();
		
		Animal lambdaLion = () -> {
			System.out.println("Roar");
		};
		lambdaLion.makeSound();

	}

}
