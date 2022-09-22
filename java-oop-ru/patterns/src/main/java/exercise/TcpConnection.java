package exercise;
import exercise.connections.Connection;
import exercise.connections.Disconnected;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;

// BEGIN
class TcpConnection {

    private Connection connection;
    private String ipAdress = "";
    private String lastWritedString = "";
    private int portNumber;

    public TcpConnection(String ipAdress, int portNumber) {
        this.connection = new Disconnected();
        this.ipAdress = ipAdress;
        this.portNumber = portNumber;
    }

    public void connect() {
        connection = connection.connect();
    }

    public void disconnect() {
        connection = connection.disconnect();
    }

    public String getCurrentState() {
        return this.connection.getCurrentState();
    }

    public void write(String s) {
        this.connection.write(s);
    }
}
// END
