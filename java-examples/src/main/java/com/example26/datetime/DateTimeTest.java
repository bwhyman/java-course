package com.example26.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.WeekFields;

public class DateTimeTest {
    public static void main(String[] args) {
        System.out.println("---------------------------");
        // getDayOfWeekAndMonth();
        System.out.println("---------------------------");
        // getLocalDate();
        System.out.println("---------------------------");
        // getLocalDatePlusMinus();
        System.out.println("---------------------------");
        // getLocalTime();
        System.out.println("---------------------------");
        // getLocalDateTime();
        System.out.println("---------------------------");
        // getWith();
        System.out.println("---------------------------");
        // getFormat();
        System.out.println("---------------------------");
        // getParse();
        System.out.println("---------------------------");
        // getUntil();
    }

    private static void getDayOfWeekAndMonth () {
        System.out.println(DayOfWeek.SUNDAY);
        System.out.println(DayOfWeek.of(7));

        System.out.println(Month.DECEMBER);
        Month sep = Month.of(9);
        System.out.println(sep);
    }

    private static void getLocalDate() {
        LocalDate date = LocalDate.of(2046, 12, 25);
        System.out.println(date);
        System.out.println("星期：" + date.getDayOfWeek());
        System.out.println("年：" + date.getYear());
        System.out.println("年日：" + date.getDayOfYear());
        System.out.println("月：" + date.getMonth());
        LocalDate date2 = LocalDate.of(2046, Month.DECEMBER, 25);
        System.out.println(date.isEqual(date2));
        System.out.println(date == date2);

        System.out.println("日期所在周是月的第几周："
                + date.get( ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH));
        System.out.println("日期所在周是全年的第几周："
                + date.get(ChronoField.ALIGNED_WEEK_OF_YEAR));
        System.out.println(date.get(ChronoField.DAY_OF_MONTH));
        System.out.println(date.get(ChronoField.DAY_OF_WEEK));

        System.out.println("当前默认周的第一天："
                + WeekFields.ISO.getFirstDayOfWeek());

        System.out.println("当前日期：" + LocalDate.now());
    }

    private static void getLocalDatePlusMinus() {
        LocalDate date = LocalDate.now();
        System.out.println(date);
        System.out.println(date.plus(10, ChronoUnit.YEARS).getYear());
        LocalDate date2 = date.plus(10, ChronoUnit.MONTHS);
        System.out.println(date2);
        System.out.println("+10个月后年：" + date2.getYear() + "; 月份："
                + date2.getMonth());
        LocalDate date3 = date.minus(30, ChronoUnit.DAYS);
        System.out.println(date3);
        System.out.println("-30天后月："
                + date3.getMonth() + "; 日："
                + date3.getDayOfMonth() + "; 星期："
                + date3.getDayOfWeek());

        System.out.println(date.minusDays(30));
        System.out.println(date.plusMonths(10));
    }

    private static void getLocalTime() {
        LocalTime time = LocalTime.of(22, 47, 38);
        System.out.println(time);
        System.out.println("时: " + time.getHour());
        System.out.println("分: " + time.getMinute());
        System.out.println("秒: " + time.getSecond());


        LocalTime time2 = time.minus(7, ChronoUnit.HOURS);
        System.out.println(time2);
        System.out.println(time2.plusMinutes(20));
    }

    private static void getLocalDateTime() {
        LocalDateTime dateTime = LocalDateTime
                .of(2046, Month.OCTOBER, 1, 8, 0);
        System.out.println(dateTime);
        LocalDate date = LocalDate.of(2046, 10, 1);
        LocalTime time = LocalTime.of(8, 0);
        LocalDateTime dateTime2 = LocalDateTime.of(date, time);
        System.out.println(dateTime2);
        System.out.println(dateTime.isEqual(dateTime2));

        LocalDateTime dateTime3 = dateTime.plusYears(1)
                .plusWeeks(2)
                .plusDays(25)
                .minusHours(7);
        System.out.println(dateTime3);
        System.out.println(dateTime3.getDayOfWeek() +
                "/" + dateTime3.getDayOfMonth());
        System.out.println(dateTime3.get(ChronoField.ALIGNED_WEEK_OF_YEAR));
        System.out.println(LocalDateTime.now());
    }

    // 基于指定时间设置
    private static void getWith() {
        LocalDateTime dateTime = LocalDateTime
                .of(2046, Month.JUNE, 14, 23, 0);
        System.out.println(dateTime.withHour(12));
        System.out.println(dateTime.withDayOfMonth(18));
        System.out.println(dateTime.with(ChronoField.DAY_OF_WEEK, 1));
    }

    private static void getFormat() {
        LocalDateTime dt = LocalDateTime.now();
        System.out.println("默认ISO格式：" + dt);
        DateTimeFormatter df1 = DateTimeFormatter.ofPattern("E yyyy-MM-dd a HH:mm:ss");
        System.out.println(dt.format(df1));

        DateTimeFormatter df2 = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm E");
        System.out.println(dt.format(df2));

        DateTimeFormatter df3 = DateTimeFormatter.ofPattern("yyyy@MM@dd");
        System.out.println(dt.format(df3));
    }
    
    private static void getParse() {
        DateTimeFormatter dateF = DateTimeFormatter
                .ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse("2046-10-01", dateF);
        System.out.println(date);

        LocalTime time = LocalTime.parse("21:17",
                DateTimeFormatter.ofPattern("HH:mm"));
        System.out.println(time);

        LocalDateTime dateTime = LocalDateTime.parse(
                "2046/12/25 24:00",
                DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
        System.out.println(dateTime);
    }

    private static void getUntil() {
        LocalDateTime OlympicGames = LocalDateTime
                .of(2021, Month.JULY, 23, 20, 0);
        LocalDateTime dNow = LocalDateTime.now();
        System.out.println(dNow);
        System.out.println("距东京奥运会还有");
        System.out.println("天：" + dNow.until(OlympicGames, ChronoUnit.DAYS));
        System.out.println("月：" + dNow.until(OlympicGames, ChronoUnit.MONTHS));
        System.out.println("年：" + dNow.until(OlympicGames, ChronoUnit.YEARS));
        System.out.println("时：" + dNow.until(OlympicGames, ChronoUnit.HOURS));
        System.out.println("分：" + dNow.until(OlympicGames, ChronoUnit.MINUTES));
    }
}
