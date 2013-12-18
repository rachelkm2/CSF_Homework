
public class DogWalker {
    public DogWalker() {
        super();
    }

    public void walkDog(Dog dog) {
        System.out.println("Walking the "+ dog.getBreed() + ", its name is " + dog.getName() + ", it has " + dog.numberOfLegs() + " legs");
        for (int i = 0; i < 5; i++) {
            System.out.println(dog.bark());
            System.out.println(dog.move());
        }
        System.out.println("Done walking " + dog.getName() + ", phew!");
    }
}
