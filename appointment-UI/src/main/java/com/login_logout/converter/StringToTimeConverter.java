package com.login_logout.converter;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.core.convert.converter.Converter;

public class StringToTimeConverter implements Converter<String, Time> {

    @Override
    public Time convert(String source) {
        if (source == null) {
            return null;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        try {
            java.util.Date date = sdf.parse(source);
            return new Time(date.getTime());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}