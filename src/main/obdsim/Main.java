package main.obdsim;

public class Main {

    public static boolean USE_BLUETOOTH = true;
    public static int SERVER_PORT = 35000;

    public static void main(String[] args) {
        int restartCount = 10;

        while(restartCount > 0) {
            restartCount--;

            if(USE_BLUETOOTH) {
                OBDBluetoothServer server = new OBDBluetoothServer();
                server.start();
            } else {
                OBDServer server = new OBDServer();
                server.start(SERVER_PORT);
            }
        }
    }

}
