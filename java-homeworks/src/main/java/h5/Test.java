package h5;

public class Test {
    public static void main(String[] args) {
        Button b1 = new Button();
        b1.setClickable(new Clickable() {
            @Override
            public void onClick() {
                System.out.println("sdfsdf");
            }
        });
    }
}
