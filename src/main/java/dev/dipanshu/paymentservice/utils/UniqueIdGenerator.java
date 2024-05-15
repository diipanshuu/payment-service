package dev.dipanshu.paymentservice.utils;

import java.util.UUID;

public class UniqueIdGenerator {

    public static String generateUniqueId() {
        return UUID.randomUUID().toString();
    }

}
