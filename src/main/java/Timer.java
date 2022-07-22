import java.time.Duration;
import java.time.LocalDateTime;

public class Timer implements Runnable {

    public void timer() throws InterruptedException {
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime timeSendMessage = LocalDateTime.now().withMinute(0).withSecond(0);
        System.out.println(timeSendMessage);
        if (timeSendMessage.isBefore(startTime)){
            timeSendMessage = timeSendMessage.plusHours(1);
        }
        System.out.println(timeSendMessage);
        Duration timeToSendMess = Duration.between(startTime,timeSendMessage);
        System.out.println(timeToSendMess.toSeconds());
        Thread.sleep(timeToSendMess.toMillis());


    }

    @Override
    public void run() {
        while (true){
            try {
                timer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
