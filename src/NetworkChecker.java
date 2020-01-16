import java.io.*;
import java.net.*;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static java.lang.Thread.sleep;


public class NetworkChecker {
    final static int TIMEOUT = 5000;
    final static int WAIT_TIME = 1000;
    final static String TEST_IP = "1.1.1.1";


    public static void main(String[] args) throws IOException, InterruptedException {
        successLoop();
    }

    public static void successLoop() throws IOException, InterruptedException {
        while (true) {
            if(ping(TEST_IP)){
                System.out.print("✔");
                Thread.sleep(WAIT_TIME);
            } else {
                failLoop();
            }
        }
    }

    public static void failLoop() throws IOException, InterruptedException {
        Stopwatch failTime = new Stopwatch();
        System.out.print(getCurrentTime() + ": " );
        while (ping(TEST_IP));
        DecimalFormat format = new DecimalFormat("#.00");
        System.out.print(format.format(failTime.getTimeElapsed()) + "s\n");
        successLoop();
    }

    public static boolean ping(String ip) throws IOException {
        InetAddress addr = InetAddress.getByName(ip);
        return addr.isReachable(TIMEOUT);
    }

    public static String getCurrentTime() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        LocalDateTime currentTime = LocalDateTime.now();
        return format.format(currentTime);
    }


}
