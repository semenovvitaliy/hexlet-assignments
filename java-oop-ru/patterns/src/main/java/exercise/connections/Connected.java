package exercise.connections;

// BEGIN
public class Connected implements Connection {

    private String lastWritedString = "";
    @Override
    public Connection connect() {
        System.out.println("Error! Already connected");
        return this;
    }

    @Override
    public Connection disconnect() {
        return new Disconnected();
    }

    @Override
    public String getCurrentState() {
        return "connected";
    }

    @Override
    public void write(String s) {
        this.lastWritedString = s;
    }
}
// END
