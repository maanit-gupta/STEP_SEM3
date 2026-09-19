package week7.assignment;

public class TrafficLight {
    private static final String[] COLORS = {"RED", "GREEN", "YELLOW"};

    private final String id;
    private int colorIndex;

    public TrafficLight(String id) {
        this.id = id;
        this.colorIndex = 0;
    }

    public String next() {
        colorIndex = (colorIndex + 1) % COLORS.length;
        return COLORS[colorIndex];
    }

    public String getColor() {
        return COLORS[colorIndex];
    }

    public String getId() {
        return id;
    }

    public static void main(String[] args) {
        TrafficLight light = new TrafficLight("TL-9");
        System.out.println(light.getColor());
        System.out.println(light.next());
        System.out.println(light.next());
        System.out.println(light.next());
    }
}
