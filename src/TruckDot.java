import java.awt.*;

public class TruckDot extends Representations{

    private Location location;
    private Location destination;
    private boolean hasArrived;

    TruckDot(Location location, Location destination) {
        super(location, destination);
        this.location = location;
        this.destination = destination;

    }

    TruckDot() {
        Location location = new Location();
        this.location = location;

    }

    public boolean isArrived(){
        return hasArrived;
    }

    @Override
    public void update() {
        if(location.equals(destination))
            hasArrived = true;
        else
        {
           //code that would make the truck move along the road
        }
    }

    @Override
    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(location.getX() - RADIUS, location.getY() - RADIUS, RADIUS * 2, RADIUS * 2);

    }
}
