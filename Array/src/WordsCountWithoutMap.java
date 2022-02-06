import java.util.StringJoiner;

public class WordsCountWithoutMap {

	public static String wordCount(String str) {

		StringJoiner sj = new StringJoiner(",");

		String[] arr = str.split(" ");
		int length = arr.length;

		int i = 0;

		int count = 1;

		while (i < length) {

			String temp = arr[i];
			for (int j = i + 1; j < length; j++) {
				if (temp.equals(arr[j])) {
					count++;
				}
			}

			String result = temp + "=" + count;
			String string2 = sj.toString();
			if (!string2.contains(temp)) {
				sj.add(result);	
			}

			count = 1;
			i++;

		}

		return sj.toString();
	}

	public static void main(String[] args) {

		String str = "Hello java Hello python Hello testing Hello java";

		String uniqueWord = wordCount(str);
		System.out.println(uniqueWord);
		
		// Hello=4,java=2,python=1,testing=1
	}

}
