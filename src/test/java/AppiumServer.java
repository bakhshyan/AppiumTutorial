import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.ServerSocket;

public class AppiumServer {
    private AppiumDriverLocalService service;
    private AppiumServiceBuilder builder;
    private DesiredCapabilities cap;
    boolean isServerRunning = false;
    public void startServer() {
        //Set Capabilities
        cap = new DesiredCapabilities();
        cap.setCapability("noReset","false");

        //Build the Appium service
        builder = new AppiumServiceBuilder();
        builder.withIPAddress("127.0.0.1");
        builder.usingPort(4723);
        builder.withCapabilities(cap);
        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");

        //Start the server with the builder
        service = AppiumDriverLocalService.buildService(builder);
        service.start();
    }

    public void stopSever() {
        service.stop();
    }

    public boolean checkIfServerIsRunning(int port) {

        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.close();
        } catch (IOException e) {

            isServerRunning = true;
        }finally {
            serverSocket = null;
        }
        return isServerRunning;
    }
    public static void main(String args[]) {
        AppiumServer appiumServer = new AppiumServer();
        int port = 4723;
        if (!appiumServer.checkIfServerIsRunning(port)) {
            appiumServer.startServer();
            appiumServer.stopSever();

        } else {

            System.out.println("Server is in use on port-" + port);
            appiumServer.stopSever();
        }
    }
}
