package com.walkdog.service.log;

/**
 * @author liu_y
 */
public abstract class IProcessor {


    /**
     * 执行
     *
     * @param time     当前时间 2020/01/01/08 年月日时
     * @param fileUrl  可以请求的文件地址
     * @param fileByte 待处理数据
     */
    abstract void execute(String time, String fileUrl, byte[] fileByte);

}
