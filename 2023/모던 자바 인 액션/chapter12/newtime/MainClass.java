package chapter12.newtime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalField;
import java.util.Locale;

public class MainClass {

    public static void main(String[] args) {

        LocalDateTime localDateTime = LocalDateTime.now();

        localDateTime.get(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH);


        DateTimeFormatter dateTimeFormatter = new DateTimeFormatterBuilder()
                .appendText(ChronoField.DAY_OF_MONTH)
                .appendLiteral(". ")
                .appendText(ChronoField.MONTH_OF_YEAR)
                .appendLiteral(" ")
                .appendText(ChronoField.YEAR)
                .parseCaseInsensitive()
                .toFormatter(Locale.ITALIAN);


    }

}
