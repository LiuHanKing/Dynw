package com.aaa.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

//时间转换器
public class DateConvertor implements Converter<String, Date>{
    private String partern;
    @Override
    public Date convert(String source) {

        // TODO Auto-generated method stub
        SimpleDateFormat format=new SimpleDateFormat(partern);
        Date date=null;
        try {
            date=format.parse(source);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return date;
    }

    public DateConvertor(String partern) {
        this.partern=partern;
    }

    public DateConvertor() {

    }
}
