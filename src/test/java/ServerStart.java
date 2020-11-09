import com.sun.security.ntlm.Server;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerStart {
    private AppiumDriverLocalService service;
    private AppiumServiceBuilder builder;
    private DesiredCapabilities cap;

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
        boolean isServerRunning = false;
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
        ServerStart serverStart = new ServerStart();
        int port = 4723;
        if (!serverStart.checkIfServerIsRunning(port)) {
            serverStart.startServer();
            serverStart.stopSever();

        } else {

            System.out.println("Server is in use on port-" + port);
            serverStart.stopSever();
        }
    }
}
