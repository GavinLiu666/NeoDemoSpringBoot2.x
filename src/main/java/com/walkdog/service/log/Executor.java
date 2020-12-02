package com.walkdog.service.log;

import java.util.Arrays;
import java.util.List;

/**
 * @author liu_y
 */
public class Executor {

    private static final List<IProcessor> PROCESSORS
            = Arrays.asList(new WriteDbProcessor(), new WriteFileProcessor());

    public static void processLog(String time, String fileUrl, byte[] fileByte) {
        for (IProcessor processor : PROCESSORS) {
            processor.execute(time, fileUrl, Arrays.copyOf(fileByte, fileByte.length));
        }
    }

}
