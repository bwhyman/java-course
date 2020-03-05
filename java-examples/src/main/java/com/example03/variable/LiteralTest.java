package com.example03.variable;

public class LiteralTest {

	public static void main(String[] args) {
		// 基本类型数据为值传递，而非引用传递
		getLiteralMeans();
	}
	
	/**
	 * 所有8个基本类型与String类型变量，不与其他变量共享值
	 * 基本数据类型为值传递，而非引用传递
	 * 因此当被"引用"的值改变时，不会影响"引用"的变量
	 */
	private static void getLiteralMeans() {
		int n1 = 10;
		int n2 = n1;
		System.out.println("n1: " + n1);
		System.out.println("n2: "  + n2);
		// 修改num1值
		n1 = 20;
		System.out.println("after changed n1: " +n1);
		System.out.println("after changed n2: " +n2);
		/*num1将字面量值10，赋值给num2
		而非num2引用num1的值
		因此num1的值改变，不影响num2的值*/
		
		String s1 = "Hello";
		String s2 = s1;
		System.out.println("before s1: " + s1);
		System.out.println("before s2: " + s2);
		// 修改s1的值
		s1 = "world";
		System.out.println("after changed s1: " + s1);
		System.out.println("after changed s2: " + s2);
	}

}
