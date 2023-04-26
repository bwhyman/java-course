package com.example23.optional;

import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {
        //ifPresent(null);
        //map(null);
        or(new USB("3.0"));
        //getVersion2(new Computer(new Soundcard(new USB("3.0"))));
    }

    /**
     * @param com
     * @return
     */
    public static String getVersion0(Computer com) {
        String v = com.getSoundcard().getUsb().getVersion();
        return v == null ? "UNKNOWN" : v;
    }

    /**
     * 冗余代码
     *
     * @param com
     * @return
     */
    private static String getVersion1(Computer com) {
        String version = "UNKNOWN";
        if (com != null) {
            Soundcard soundcard = com.getSoundcard();
            if (soundcard != null) {
                USB usb = soundcard.getUsb();
                if (usb != null) {
                    version = usb.getVersion();
                }
            }
        }
        return version;
    }

    /**
     * 打印传入的usb版本。传入的usb对象可能为空
     * 仅不为空执行，执行时既然可能空引用
     *
     * @param usb
     */
    private static void ifPresent(USB usb) {
        Optional<USB> usbOP = Optional.ofNullable(usb);
        usbOP.ifPresent(u -> System.out.println(u.getVersion()));

        Optional.ofNullable(usb)
                .ifPresent(u -> System.out.println(u.getVersion()));
        System.out.println("dfsf");
        Optional.ofNullable(new Computer())
                .ifPresent(c -> System.out.println(c.getSoundcard().getUsb()));
    }


    /**
     * java9
     */
    private static void ifPresentOrElse(USB usb) {
        Optional.ofNullable(usb)
                .ifPresentOrElse(u -> System.out.println(u.getVersion()),
                        () -> System.out.println("dfdf"));

    }

    /**
     * 如果版本为3.0打印，否则不执行操作
     */
    private static void filter(USB usb) {
        Optional.ofNullable(usb)
                .filter(u -> "3.0".equals(u.getVersion()))
                .ifPresent(u -> System.out.println(u.getVersion()));
    }

    /**
     * 基于map映射usb版本，打印
     *
     * @param usb
     */
    private static void map(USB usb) {
        Optional.ofNullable(usb)
                .map(USB::getVersion)
                .ifPresent(System.out::println);
    }

    /**
     * 打印版本
     * 为UNKNOWN，创建一个1.1版本usb
     * 不为UNKNOWN，直接打印
     */
    private static void or(USB usb) {
        Optional.of(usb)
                .filter(u -> !"UNKNOWN".equals(u.getVersion()))
                .or(() -> Optional.of(new USB("1.1")))
                .map(USB::getVersion)
                .ifPresent(System.out::println);
    }

    /**
     * 如果usb版本为空，返回UNKNOWN
     * 获取版本
     *
     * @param usb
     */
    private static void orElse(USB usb) {
        String v1 = Optional.ofNullable(usb)
                .map(USB::getVersion)
                .orElseGet(() -> "UNKNOWN");
        System.out.println(v1);

        String v2 = Optional.ofNullable(usb)
                .map(USB::getVersion)
                .orElse("UNKNOWN");
        System.out.println(v2);

    }

    private static void Get(USB usb) {
        String v = Optional.ofNullable(usb)
                .or(() -> {
                    System.out.println("怎么会没有呢");
                    return Optional.of(new USB("1.1"));
                })
                .get()
                .getVersion();
    }

    /**
     * 获取Computer的usb版本
     *
     * @param com
     */
    private static void getVersion2(Computer com) {
        String v = Optional.ofNullable(com)
                .map(Computer::getSoundcard)
                .map(Soundcard::getUsb)
                .map(USB::getVersion)
                .orElse("UNKNOWN");
        System.out.println(v);
    }

}
