import java.time.Duration;
import java.time.LocalDateTime;

public class Timer implements Runnable {
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
    public void timer() throws InterruptedException {
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime startDays = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0);
        LocalDateTime timeSendMessage = LocalDateTime.now().withMinute(0).withSecond(0);
        if (timeSendMessage.isBefore(startTime)){
            timeSendMessage = timeSendMessage.plusHours(1);
        }
        Duration timeToSendMess = Duration.between(startTime,timeSendMessage);
        Duration hour = Duration.between(startDays,timeSendMessage);
        Thread.sleep(timeToSendMess.toMillis());
        GetInfToSendUser getInfToSendUser = new GetInfToSendUser();
        getInfToSendUser.getUserSett((int)hour.toHours());
    }
}
