package serviceClasses;

import monobank.APIMonobank;
import nbu.APINbu;
import privat.APIPrivat;
import settings.Banks;
import settings.Currency;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

public class CurrencyDataBase {
    public static HashMap<Banks, Bank> currentInfo = new HashMap<>();

    public static Bank getCurrentInfo(Banks bankName) {
        if (currentInfo.get(bankName) == null) {
            try {
                setCurrentInfo(bankName);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return currentInfo.get(bankName);
    }

    public static void setCurrentInfo(Banks bankName) throws IOException, InterruptedException {
        switch (bankName) {
            case PRIVATE:
                Bank bankPrivat = APIPrivat.getPrivatAPI();
                bankPrivat.setTime(LocalDateTime.now());
                currentInfo.put(bankName, bankPrivat);
                System.out.println("HashMap " + currentInfo + " розмір " + currentInfo.size());
                break;
            case MONO:
                Bank bankMono = APIMonobank.getMonoAPI();
                bankMono.setTime(LocalDateTime.now());
                currentInfo.put(bankName, bankMono);
                System.out.println("HashMap " + currentInfo + " розмір " + currentInfo.size());
                break;
            case NBU:
                Bank bankNBU = APINbu.getNBUAPI();
                bankNBU.setTime(LocalDateTime.now());
                currentInfo.put(bankName, bankNBU);
                System.out.println("HashMap " + currentInfo + " розмір " + currentInfo.size());
                break;
        }

    }

    public Bank getCurrencyRates(Banks bankName) throws IOException, InterruptedException {
        Bank bank = currentInfo.get(bankName);
        LocalDateTime currentTime = LocalDateTime.now();
        long timeDiff = Duration.between(LocalDateTime.now(), bank.getTime()).toMinutes();
        if (timeDiff > 5) {
            setCurrentInfo(bankName);
        }
        return currentInfo.get(bankName);
    }


}
