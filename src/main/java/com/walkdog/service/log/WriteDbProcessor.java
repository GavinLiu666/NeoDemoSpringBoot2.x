package com.walkdog.service.log;

import java.util.Arrays;
import java.util.List;

/**
 * @author liu_y
 */
public class WriteDbProcessor extends IProcessor {

    @Override
    public void execute(String time, String fileUrl, byte[] fileByte) {
        String strData = new String(fileByte);
        List<String> jsonList = Arrays.asList(strData.split("\\n"));
        System.out.println(jsonList);
    }

}
