
public abstract class Dog implements Moveable {
    private String name;

    private Dog() {
        super();
    }

    public Dog(String name) {
        this();
        this.name = name;
    }

    public final int numberOfLegs() {
        return 4;
    }

    public String bark() {
        return "Woof!";
    }

    public String getName() {
        return this.name;
    }

    public String move() {
        return "Walked 4 steps!";
    }

    public abstract String getBreed();
}
