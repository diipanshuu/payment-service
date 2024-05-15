package dev.dipanshu.paymentservice.utils;

import java.time.Duration;
import java.time.Instant;

public class EpochTimestampGenerator {

    public static long generateEpochTimestamp(){
        Instant instant = Instant.now().plus(Duration.ofMinutes(30));
        return instant.getEpochSecond();
    }

}
