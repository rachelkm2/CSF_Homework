public class ElevatorScheduler {
    private Elevator[] elevators;

    public ElevatorScheduler(Elevator[] elevators) {};

    /**
     * To be called by the building when a floor button is pressed in an elevator bank.
     * This method queries the current state (direction, current floor, whether it's moving) of each elevator, then
     * enqueues a request to the best elevator to go to the desired floor.
     * @param floor The floor that the button was pressed on
     * @param direction The direction of the request
     */
    public void floorCallButtonPressed(int floor, ElevatorDirection direction) {};

    /**
     * Restricts the elevator at the given index to a specific set of floors. To be called by a building administrator.
     * @param elevatorNumber The index of the elevator to restrict. Must be lower than the number of elevators in the system.
     * @param floorRestrictions A boolean array of floors that are allowed by that elevator. true indicates that
     *                          the elevator can go to that floor.
     */
    public void restrictElevatorToFloors(int elevatorNumber, boolean[] floorRestrictions) {};
}
