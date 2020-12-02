package com.walkdog.entity.request;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author liu_y
 */
public class LogRequest {

    /**
     * "2020/11/02"
     */
    private String fromDate;

    private String toDate;


    public LocalDate getFromDateTime() {
        return convert(this.fromDate);
    }

    public LocalDate getToDateTime() {
        return convert(this.toDate);
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    private LocalDate convert(String date) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        System.out.println(date);
        return LocalDate.parse(date, df);
    }

    public static class LogRequestBody {
        private String dir;

        public LogRequestBody(String dir) {
            this.dir = dir;
        }

        public String getDir() {
            return dir;
        }

        public void setDir(String dir) {
            this.dir = dir;
        }

        @Override
        public String toString() {
            return "LogRequestBody{" +
                    "dir='" + dir + '\'' +
                    '}';
        }
    }

}
