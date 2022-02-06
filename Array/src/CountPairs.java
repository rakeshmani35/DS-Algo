import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountPairs {

	 public static int countPairs(List<Integer> numbers, int k) {
		    // Write your code here
		 int temp = k;
		 Set<Integer> set = new HashSet(numbers);
		            HashMap<Integer,Integer> map = new HashMap<>();
		            for (Integer integer : set) {
		                map.put(integer, 1);
		            }
		          int count = 0;
		            for (Integer integer : set) {
		                if (map.containsKey(integer+temp)) {
		                    count++;
		                    map.remove(integer);
		                }
		            }

		            return count;
		    }
	
	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(1,1,2,2,3,3,1);
		int countPairs = countPairs(numbers, 2);
		System.out.println(countPairs);

	}

}
