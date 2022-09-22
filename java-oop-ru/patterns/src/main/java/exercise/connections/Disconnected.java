package exercise.connections;

// BEGIN
public class Disconnected implements Connection {

    @Override
    public Connection connect() {
        return new Connected();
    }

    @Override
    public Connection disconnect() {
        System.out.println("Error! Already disconnected");
        return this;
    }

    @Override
    public String getCurrentState() {
        return "disconnected";
    }

    @Override
    public void write(String s) {
        System.out.println("Error! Disconnected now");
    }
}
// END
