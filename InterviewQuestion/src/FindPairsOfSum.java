import java.util.ArrayList;
import java.util.List;

public class FindPairsOfSum {

	public static void pair(int a, int b, int sum, List<String> list) {

		if (a + b > sum) {
			return;
		}

		if (a + b == sum) {
			// System.out.println("Pairs = (" + a + " : " + b+")");
			list.add("(" + a + " : " + b + ")");

			return;
		}

		pair(a + b, b, sum, list);
		pair(a, b + a, sum, list);

		return;
	}

	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();

		pair(1, 3, 18, list);

		if (!list.isEmpty()) {
			System.out.println("Pairs = " + list);
		} else {
			System.out.println("no pair found");
		}

	}

}
