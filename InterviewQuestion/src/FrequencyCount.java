// https://www.javatpoint.com/program-to-find-the-frequency-of-characters

public class FrequencyCount {

	public static void frequencyCount(String str) {

		char[] charArray = str.toCharArray();
		int[] count = new int[str.length()];

		for (int i = 0; i < str.length(); i++) {
			count[i] = 1;
			for (int j = i+1; j < str.length(); j++) {
                   if (charArray[i] == charArray[j]) {
					count[i]++;
					
					  //Set charArray[j] to 0 to remove character for avoid printing
	                   charArray[j] = '0';
				}
			}
		}
		for (int i = 0; i < count.length; i++) {
			   if(charArray[i] != ' ' && charArray[i] != '0')  {
				System.out.println(charArray[i]+"-"+count[i]);
			}
		}
		
	}

	public static void main(String[] args) {

		String str = "picture perfect";
		frequencyCount(str);

	}

}
