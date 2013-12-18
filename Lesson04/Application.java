public class Application {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Dog fido = new Chihuahua("Fido");
        Dog rover = new Pitbull("Rover");
        DogWalker walker = new DogWalker();
        walker.walkDog(fido);
        walker.walkDog(rover);
    }
}