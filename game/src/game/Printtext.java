package game;

import java.util.Random;
import java.util.Scanner;

public class Printtext {

	public static void main(String ards[]) {
//		Go ea=new Go();
//		ea.main(ards);
//---------------------------------------------
		Scanner scan = new Scanner(System.in);
		System.out.println("n:");
		int n = scan.nextInt();
		if (n <= 10 && n >= 0) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n - i; ++j) {
					System.out.print("*");
				}
				System.out.println();
			}
		} else {
			System.out.println("no");
		}

//--------------------------------------------------、
		int numbers[] = { 1, 2, 3, 4, 5 };
		for (int number : numbers) {
			System.out.print(number);
		}
		System.out.println();
// --------------------------------------------------
		int point1 = 0, point2 = 0, point3 = 0, point4 = 0, point5 = 0, point6 = 0;
		Random rd = new Random();
		for (int i = 1; i <= 100; i++) {
			int point = rd.nextInt(7);
			switch (point) {
			case 1: {
				point1++;
				break;
			}
			case 2: {
				point2++;
				break;
			}
			case 3: {
				point3++;
				break;
			}
			case 4: {
				point4++;
				break;
			}
			case 5: {
				point5++;
				break;
			}
			case 6: {
				point6++;
				break;
			}

			}
		}
		System.out.println("1は" + point1 + "回");
		System.out.println("2は" + point2 + "回");
		System.out.println("3は" + point3 + "回");
		System.out.println("4は" + point4 + "回");
		System.out.println("5は" + point5 + "回");
		System.out.println("6は" + point6 + "回");

	}

}
