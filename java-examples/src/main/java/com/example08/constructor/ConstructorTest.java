package com.example08.constructor;

public class ConstructorTest {

    public static void main(String[] args) {
        System.out.println("--------Constructor--------");
        getBicycle();
        System.out.println("--------Passing Reference Data Type Arguments--------");
        Bicycle bicycle = new Bicycle();
        bicycle.setGear(5);
        getReferenceData(bicycle);
        System.out.println("After the method called: " + bicycle.getGear());
        System.out.println("--------Create Objects--------");
        createObjects();
    }

    private static void getBicycle() {
        Bicycle bicycle = new Bicycle(5,15);
        bicycle.setSpeed(20);
        bicycle.setMoving(true);
        System.out.println(bicycle.getCadence());
        System.out.println(bicycle.getGear());
        System.out.println(bicycle.getSpeed());
        System.out.println(bicycle.isMoving());
    }

    /**
     * 对象的引用传递给方法
     * @param bicycle
     */
    private static void getReferenceData(Bicycle bicycle) {
        System.out.println("grear in method: " + bicycle.getGear());
        bicycle.setGear(2);
        System.out.println("grear after changed in method: " + bicycle.getGear());
    }

    //
    private static void createObjects() {
        //仅声明了变量，未引用任何对象
        Bicycle bicycle;
        // 声明引用一个新创建的对象1
        bicycle = new Bicycle();
        System.out.println("bicycle引用的对象1：\n" + bicycle);
        // gear为基本数据类型，自动初始化
        System.out.println(bicycle.getGear());
        // 声明变量，创建并引用一个新对象，对象2
        Bicycle bicycle2 = new Bicycle(999);
        System.out.println("bicycle2引用的对象2：\n" + bicycle2);
        // 变量bicycle引用bicycle2引用的对象，即对象2
        // 此时，没有引用对象1的变量
        // 在下一周期，垃圾回收器GC将回释放对象1占用的内存
        bicycle = bicycle2;
        // 变量bicycle操作新指向的对象
        System.out.println(bicycle.getGear());
        // 将变量bicycle引用置空，即不再引用任何对象
        bicycle = null;
        // 但变量bicycle2仍然引用对象2
        // 因此，此时对象2不会被回收

    }


}
