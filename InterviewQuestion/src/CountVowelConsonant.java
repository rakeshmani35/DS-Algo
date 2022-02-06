// https://www.javatpoint.com/program-to-count-the-total-number-of-vowels-and-consonants

public class CountVowelConsonant {

	public static void CountVowelAndConsonant(String str) {

		str = str.toLowerCase();

		int vCount = 0;
		int cCount = 0;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o'
					|| str.charAt(i) == 'u') {
				vCount++;
			}else if (str.charAt(i) >= 'a' || str.charAt(i) <= 'z') {
				cCount++;
			}
		}
		
		System.out.println("Number of vowels: " + vCount);  
        System.out.println("Number of consonants: " + cCount); 
	}

	public static void main(String[] args) {

		String str = "This is a really simple sentence";
		CountVowelAndConsonant(str);
	}

}
