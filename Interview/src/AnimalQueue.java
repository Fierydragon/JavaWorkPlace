import java.util.LinkedList;
import java.util.Scanner;

abstract class Animal {
	String name = null;
	int order = 0;
}

class Dog extends Animal {
	Dog(String n) {
		this.name = n;
	}
}

class Cat extends Animal {
	Cat(String n) {
		this.name = n;
	}
}

public class AnimalQueue {
	private int index = 0;
	LinkedList<Dog> dogs = new LinkedList<Dog>();
	LinkedList<Cat> cats = new LinkedList<Cat>();
	
	private Animal popAny(){
		if(!dogs.isEmpty() && !cats.isEmpty()){
			if(dogs.peek().order < cats.peek().order)
				return popDog();
			else
				return popCat();
		} else if(dogs.isEmpty() && cats.isEmpty()){
			return null;
		} else {
			if(dogs.isEmpty())
				return popCat();
			else
				return popDog();
		}
	}
	private void enqueue(Animal a){
		if(a instanceof Dog){
			a.order = index++;
			dogs.addLast((Dog) a);
		} else if(a instanceof Cat){
			a.order = index++;
			cats.addLast((Cat) a);
		}
	}
	private Animal popDog(){
		if(!dogs.isEmpty()){
			Dog dog = dogs.poll();
			System.out.println(dog.name + dog.order);
			return dog;
		} else 
			return null;
	}
	private Animal popCat(){
		if(!cats.isEmpty()){
			Cat cat = cats.poll();
			System.out.println(cat.name + cat.order);
			return cat;
		} else
			return null;
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		AnimalQueue aq = new AnimalQueue();
		
		while(sc.hasNext()){
			String operation = sc.next();
			//System.out.println(operation);
			if(operation == "-1")
				break;
			else if(operation.equals("pushDog")){
				aq.enqueue(new Dog("dog"));
			} else if(operation.equals("pushCat")){
				aq.enqueue(new Cat("cat"));
			} else if(operation.equals("popDog")){
				System.out.println("popDog");
				aq.popDog();
			} else if(operation.equals("popCat")){
				System.out.println("popCat");
				aq.popCat();
			} else if(operation.equals("popAny")){
				System.out.println("popAny");
				aq.popAny();
			}
		}
		sc.close();
	}
}