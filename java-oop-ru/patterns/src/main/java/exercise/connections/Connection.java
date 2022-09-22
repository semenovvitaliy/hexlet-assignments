package exercise.connections;

public interface Connection {
    // BEGIN
    Connection connect();
    Connection disconnect();
    String getCurrentState();
    void write(String s);
    // END
}
