package com.example.kafka.util;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import com.example.kafka.model.Call;
import com.example.kafka.model.CallType;
import com.example.kafka.model.Direction;

public class CallCreator {
    private static final CallType[] CALL_TYPES = CallType.values();
    private static final Direction[] DIRECTIONS = Direction.values();

    public static Call createCall() {
        final Call call = new Call();
        call.setDirection(DIRECTIONS[ThreadLocalRandom.current().nextInt(0, DIRECTIONS.length)]);
        call.setCallType(CALL_TYPES[ThreadLocalRandom.current().nextInt(0, CALL_TYPES.length)]);
        call.setStartTime(new Date());
        call.setSipResponseCode(200);

        return call;
    }
}
