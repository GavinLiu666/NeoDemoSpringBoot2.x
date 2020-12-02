package com.walkdog.service.log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author liu_y
 */
public class WriteFileProcessor extends IProcessor {

    @Override
    public void execute(String time, String fileUrl, byte[] fileByte) {
        String fileName = fileUrl.substring(fileUrl.lastIndexOf("/") + 1);
        String fileNamePre = time.replaceAll("\\/", "_");
        File file = new File(fileNamePre + "-" + fileName + ".log");
        try (FileOutputStream fos = new FileOutputStream(file)) {
            if (fileByte == null) {
                return;
            }
            fos.write(fileByte);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
