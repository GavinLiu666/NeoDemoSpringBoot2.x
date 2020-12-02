package com.walkdog.service;

import com.walkdog.entity.request.LogRequest;
import com.walkdog.entity.response.LogResponse;
import com.walkdog.service.log.Executor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author liu_y
 */
@Service
public class AliLogService {

    private static final String URL = "http://web.liangyihui.net/mdtj/fanyi/listLogDir";

    private final RestTemplate restTemplate = new RestTemplate();


    public void requestLog(LogRequest request) {

        LocalDate fromDate = request.getFromDateTime();
        String fromDateStr = request.getFromDate();
        String toDateStr = request.getToDate();
        while (fromDateStr.compareTo(toDateStr) <= 0) {
            for (int i = 0; i < 24; i++) {
                String separator = i < 10 ? "/0" : "/";
                String time = fromDateStr + separator + i;
                LogRequest.LogRequestBody body = new LogRequest.LogRequestBody(time);

                LogResponse response = restTemplate.postForObject(URL, body, LogResponse.class);
                if (null == response) {
                    continue;
                }

                List<String> fileList = response.getData();
                if (CollectionUtils.isEmpty(fileList)) {
                    continue;
                }

                for (String fileUrl : fileList) {
                    System.out.println(fileList);
                    byte[] fileByte = restTemplate.getForObject(fileUrl, byte[].class);
                    Executor.processLog(time, fileUrl, fileByte);
                }
            }
            fromDate = fromDate.plusDays(1);
            fromDateStr = fromDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        }

    }


}
