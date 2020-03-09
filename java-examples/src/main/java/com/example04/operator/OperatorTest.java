package com.example04.operator;

public class OperatorTest {
    public static void main(String[] args) {
        getArithmeticOperators();
        System.out.println("------------");
        getCompoundAssignments();
        System.out.println("------------");
        getUnary();
        System.out.println("------------");
        getPrePost();
        System.out.println("------------");
        getComparison();
        System.out.println("------------");
        getConditional();
        System.out.println("------------");
        getTernaryOperator();
        System.out.println("------------");
        getComput();
        System.out.println("------------");
        getQuestions();
    }
    /**
     * 算数运算符
     */
    private static void getArithmeticOperators() {
        int result = 10;
        // result is now 3
        System.out.println(result + " % 7 = " +  result % 7);

        String firstString = "This is";
        String secondString = " a concatenated string.";
        String thirdString = firstString + secondString;
        System.out.println(thirdString);
    }


    /**
     * 复合运算符
     */
    private static void getCompoundAssignments() {
        int i = 1;
        i = i + 1;
        int r = 1;
        r += 1;
        System.out.println(i);
        System.out.println(r);
    }
    /**
     * 一元运算符
     */
    private static void getUnary() {
        int result = 1;
        // result is now 1
        System.out.println(result);
        result--;
        // result is now 0
        System.out.println(result);
        result++;
        // result is now 1
        System.out.println(result);
        result = - result;
        // result is now -1
        System.out.println(result);
        boolean success = false;
        // false
        System.out.println(success);
        // true
        System.out.println(!success);
    }

    /**
     * ++i 等价于 i = i + 1; return i;
     * i++ 等价于 return i; i = i+1;
     */
    private static void getPrePost() {
        int i = 3;
        i++;
        // prints 4
        System.out.println(i);
        ++i;
        // prints 5
        System.out.println(i);
        // prints 6
        System.out.println(++i);
        // prints 6
        System.out.println(i++);
        // prints 7
        System.out.println(i);
    }
    /**
     * 比较运算符
     */
    private static void getComparison() {
        int n1 = 1;
        int n2 = 2;
        System.out.println(n1 == n2);
        boolean b1 = true;
        boolean b2 = false;
        System.out.println(b1 != b2);
        float f1 = 12.33F;
        float f2 = 17.66F;
        System.out.println(f1 >= f2);

    }

    private static void getConditional() {
        int v1 = 2;
        int v2 = 2;
        if ((v1 == 1) && (v2 == 2)) {
            System.out.println("v1 is 1 AND v2 is 2");
        } else {
            System.out.println("false");
        }
        int v3 = 2;
        int v4 = 5;
        if ((v3 == 1) || (v4 == 5)) {
            System.out.println("v3 is 1 OR v4 is 4");
        } else {
            System.out.println("false");
        }
    }
    /**
     * 三元运算符
     */
    private static void getTernaryOperator() {
        int v1 = 1;
        int v2 = 2;
        int result;
        result = v1 > v1 ? v1 + 10 : v2 - 10;
        System.out.println(result);
    }
    private static void getTernaryOperator2(int usbVersion) {
        String speedString2 = usbVersion >= 3 ? "high" : "slow";
        System.out.println(speedString2);
    }

    /**
     * 基本数据类型的转换标准
     */
    private static void getComput() {
        int i1 = 4;
        int i2 = 3;
        double d1 = 3D;
        int i3 = (int) d1;
        System.out.println(i1 / i2);
        System.out.println(i1 / d1);
        System.out.println(i1 / i2 / d1);
        System.out.println(i1 / (i2 / d1));
    }

    /**
     * 结果
     */
    private static void getQuestions() {
        int i = 10;
        int n = i ++% 5;
        System.out.println(i);
        System.out.println(n);

        int x = 10;
        int r = ++x % 5;
        System.out.println(x);
        System.out.println(r);

        int num1 = 10;
        int num2 = 1;
        System.out.println(num1+++num2);

        System.out.println(num1 + num2);
        num1++;

    }
}
