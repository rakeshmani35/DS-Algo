package com.opentext;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * print maximum repeatable character which coming first.
 * 
 * "aabcccdddbb" count os a=2,b=3 c=3,d=2. where 'b' and 'c' has maximum count
 * is 3. But 'b' comes first. So print 'b'
 * 
 * @author rakes
 *
 */
public class MaximumOccuranceCharacter {

	public static char maxOccu(String text) {
		Map<String, Integer> map = new LinkedHashMap<>();

		String key = null;
		int value = 0;
		char c = (char) 0;
		int max = Integer.MAX_VALUE;
		if (text != null && text.length() > 0) {
			String[] strArr = text.split("");
			for (String str : strArr) {
				if (map.containsKey(str)) {
					map.put(str, map.get(str) + 1);
				} else {
					map.put(str, 1);
				}
			}
			for (Map.Entry<String, Integer> entry : map.entrySet()) {
				String k = entry.getKey();
				int v = entry.getValue();

				if (value < v) {
					key = k;
					value = v;
				}
			}
		} else {
			return c;
		}

		return key.charAt(0);
	}

	public static void main(String[] args) {

		String text = "aabcccdddbb";
		// String text = "";
		char maxOccu = maxOccu(text);

		System.out.println(maxOccu);
	}

}
