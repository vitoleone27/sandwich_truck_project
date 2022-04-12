/*
Class used for generating the basic drawn components of the Jframe Truck_Map. Components can be added in various
methods and then added to paint() in other to be drawn on the JFrame.
 */

import javax.swing.*;
import java.awt.*;

public class TruckMap extends JPanel {
    public Truck truck;
    public ServiceCenter serviceCenter;
    public RedHouse redHouse;

    /**
     * creates the service center and a basic truck to check if movement works
     */
    TruckMap(RouteStrategy strategy) {

        truck = new Truck(strategy);
        serviceCenter = new ServiceCenter();
        redHouse = new RedHouse(strategy);
    }

    /**
     * Calls TruckDot's update so that TruckSim does not need to deal with the TruckDot class
     */
    public void update() {
        if (truck.location.equals(redHouse.location)) {
            redHouse.update();
        }
        truck.update();
    }

    /**
     * Draws the basic gridlines on the JFrame, which are used to position addresses
     * @param g
     */
    void drawNeighborhood(Graphics g) {
        // Vertical Streets
        for (int x = 1; x <= 1001; x = x + 100)
            g.drawLine(x, 0, x, 1000);

        // Horizontal Streets
        for (int y = 0; y <= 1000; y = y + 100)
            g.drawLine(0, y, 1000, y);
    }

    /**
     * Method used to control the drawing components on the JFrame
     * @param g
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawNeighborhood(g);
        redHouse.paintComponent(g);
        truck.paintComponent(g);
        serviceCenter.paintComponent(g);

        g.drawString(String.format("Distance Travelled: %.2f miles", truck.getDistanceTravelled()), 1010, 15);
        g.drawString("Current Location: " + truck.letterLocation(truck.getLocationX()) + truck.getLocationY() + " Street", 1010, 65);
        g.drawString("Current Destination: " + redHouse.letterLocation(redHouse.getLocationX()) + redHouse.getLocationY() + " Street", 1010, 115);
    }

    /**
     * returns true if truck has orders left on its route
     * @return
     */
    public boolean truckHasOrders() {
        return truck.hasDestinations();
    }
}
