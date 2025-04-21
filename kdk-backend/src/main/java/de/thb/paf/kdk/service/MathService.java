package de.thb.paf.kdk.service;

import de.thb.paf.kdk.model.MathTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Slf4j
public class MathService {
    private Map<String, Integer> taskMap;

    public MathService() {
        //we use the concurrent hash map because we want the math service to be ready to be used by multiple users in a thread safe way
        taskMap = new ConcurrentHashMap<>();
    }

    private int getRandom() {

        int range = 20;
        return (int) ((range * Math.random()) + 1);
    }



    public MathTask getRandomMathTask() {
        int a = getRandom();
        log.info("Zahl 1 = " + a);

        int b = getRandom();
        log.info("Zahl 2 = " + b);

        int c = a + b;
        log.info("Ergebnis = "+ c);

        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
        log.info(uuidAsString);

        taskMap.put(uuidAsString,c);

        return new MathTask(a+" + "+b, uuidAsString);
    }
}
