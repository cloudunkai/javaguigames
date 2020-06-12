package game;

import java.util.Scanner;

public class Go {
	public static void main(String[] args) {
		int[] answer = new int[4];
		int[] user = new int[4];
		// 乱数作成メソッド
		int[] array = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int remainder = 10;
		for (int i = 0; i < 4; i++) {
			int select = (int) (Math.random() * remainder);
			answer[i] = array[select];
		}
		if (answer[0] == 0) {
			answer[0] = (int) (Math.random() * remainder + 1);
		}

		for (int c = 0; c < 4; c++) {
			for (int x = c + 1; x < 4; x++) {
				if (answer[c] == answer[x]) {
					answer[c] = (int) (Math.random() * remainder);
					continue;
				}
			}
		}
		for (int k = 0; k < 4; k++) {
			System.out.print(answer[k]);
		}
		int count = 1;

		while (true) {
			System.out.println(" ");
			System.out.println("4桁の数字を入力してください");
			Scanner scan = new Scanner(System.in);
			String str1 = scan.nextLine();
			System.out.println(" ");

			// 入力値が4文字化のチェック
			boolean error = false;
			int length = str1.length();
			if (length != 4) {
				error = true;
			}
			for (int i = 0; i < length; i++) {
				char c = str1.charAt(i);
				if (c < '0' || c > '9') {
					error = true;
				}
			}
			for (int i = 0; i < length; i++) {
				for (int j = i + 1; j < length; j++) {
					if (str1.charAt(i) == str1.charAt(j)) {
						error = true;
					}
				}
			}
			// 入力のエラー発生
			if (error == true) {
				System.out.println("入力エラーです");
				System.out.println("0から9までの数値を4桁で重複しないように入力してください");
				System.out.println(" ");
				continue;
			}
			// str1をuserに代入
			for (int i = 0; i < length; i++) {
				user[i] = Integer.parseInt(str1.substring(i, (i + 1)));
			}
			// hitの判定
			int hit = 0;
			for (int i = 0; i < 4; i++) {
				if (user[i] == answer[i]) {
					hit++;
				}
			}
			// blowの判定
			int blow = 0;
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (user[i] == answer[j]) {
						blow++;
					}
				}
			}
			// 結果
			if (hit == 4) {
				System.out.println("正解です" + count + "回目で正解です");
				System.out.println(" ");
				break;
			} else {
				System.out.println("hit" + hit + "個、blow" + (blow - hit) + "個");
				System.out.println(" ");
				count++;
			}
		}
	}
}