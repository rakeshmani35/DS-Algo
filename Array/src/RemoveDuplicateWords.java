
public class RemoveDuplicateWords {

	public static void remove(String str) {

		int index = 0;
		String[] s1 = str.split(" ");

		String[] result = new String[s1.length];

		for (int i = 0; i < s1.length; i++) {

			int j;
			for (j = 0; j < i; j++) {
				if (s1[j].equals(s1[i])) {
					
					break;
				}
			}

			// If not present, then add it to
			// result.
			if (j == i) {
				result[index++] = s1[i];
			}
		}
		return;
	}

	public static void main(String[] args) {
		String str = "geeks for geeks";
		remove(str);
		System.out.println(str);
	}

}
