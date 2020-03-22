package com.example12.nestedclass;

public class Person {
    private String name;
    private IQ iq;

    public Person(String name, IQ iq) {
        this.name = name;
        this.iq = iq;
    }

    /**
     *
     */
    public static class IQ {
        private int point;
        public IQ(int point) {
            this.point = point;
        }

        public int getPoint() {
            return point;
        }

        public void setPoint(int point) {
            this.point = point;
        }
    }
    public IQ getIq() {
        return iq;
    }
    public void setIq(IQ iq) {
        this.iq = iq;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
