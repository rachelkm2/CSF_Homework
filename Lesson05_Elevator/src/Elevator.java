import java.util.Queue;

public class Elevator {
    private boolean isAlarming;
    private boolean[] litUpFloors;
    private Queue<Integer> destinationFloors;
    private int floor;
    private ElevatorDirection direction;
    private boolean active;

    public Elevator(int numberOfFloors) {}

    public boolean isActive() {
        return active;
    }

    /**
     * @param active Setting this to true causes the elevator to start processing its destinationFloors queue,
     *               false causes the elevator to stop processing its destinationFloors queue.
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    public ElevatorDirection getDirection() {
        return direction;
    }

    public int getFloor() {
        return floor;
    }

    public boolean isAlarming() {
        return isAlarming;
    }

    /**
     * To be called internally if an 'alarm' button is pressed, or externally in the event of a building emergency.
     */
    public void setAlarming(boolean isAlarming) {
        this.isAlarming = isAlarming;
    }

    /**
     * Enqueues a given floor as a destination and sets it as 'lit up'.
     * To be called by this class when an internal floor button is pressed.
     * @param floorNumber The floor to set selected
     */
    private void internalFloorButtonPressed(int floorNumber) {};

    /**
     * Enqueues a given floor as a destination but does not set it as 'lit up'.
     * To be called by the class that owns Elevator.
     * @param floorNumber The floor number to enqueue.
     */
    public void enqueueFloorAsDestination(int floorNumber) {};
}
