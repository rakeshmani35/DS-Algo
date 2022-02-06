import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Pairs<U, V> {
	public U first;
	public V second;

	public Pairs(U first, V second) {
		this.first = first;
		this.second = second;
	}

	// this method gives object of pair class
	public static <U, V> Pairs<U, V> of(U a, V b) {
		return new Pairs<>(a, b);
	}

	public U getFirst() {
		return first;
	}

	public void setFirst(U first) {
		this.first = first;
	}

	public V getSecond() {
		return second;
	}

	public void setSecond(V second) {
		this.second = second;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + ((second == null) ? 0 : second.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pairs other = (Pairs) obj;
		if (first == null) {
			if (other.first != null)
				return false;
		} else if (!first.equals(other.first))
			return false;
		if (second == null) {
			if (other.second != null)
				return false;
		} else if (!second.equals(other.second))
			return false;
		return true;
	}

}

public class PairOfSongsToPlay {

	public static long playlist(List<Integer> songs) {

		List<Integer> list = Arrays.asList(60, 120, 180);

		Set<Pairs<Integer, Integer>> set = new HashSet<Pairs<Integer, Integer>>();

		for (int i = 0; i < songs.size(); i++) {

			if (songs.indexOf(60 - songs.get(i)) != -1
					&& songs.indexOf(songs.get(i)) != songs.indexOf(60 - songs.get(i))) {
				Pairs p;
				if (songs.get(i) < 60 - songs.get(i)) {
					p = new Pairs(songs.get(i), 60 - songs.get(i));
				} else {
					p = new Pairs(60 - songs.get(i), songs.get(i));
				}
				set.add(p);

			}
			if (songs.indexOf(120 - songs.get(i)) != -1
					&& songs.indexOf(songs.get(i)) != songs.indexOf(120 - songs.get(i))) {
				Pairs p;
				if (songs.get(i) < 120 - songs.get(i)) {
					p = new Pairs(songs.get(i), 120 - songs.get(i));
				} else {
					p = new Pairs(120 - songs.get(i), songs.get(i));
				}
				set.add(p);
			}
			if (songs.indexOf(180 - songs.get(i)) != -1
					&& songs.indexOf(songs.get(i)) != songs.indexOf(180 - songs.get(i))) {
				Pairs p;
				if (songs.get(i) < 180 - songs.get(i)) {
					p = new Pairs(songs.get(i), 180 - songs.get(i));
				} else {
					p = new Pairs(180 - songs.get(i), songs.get(i));
				}
				set.add(p);
			}
		}

		printSet(set);
		return set.size();

	}

	public static void printSet(Set<Pairs<Integer, Integer>> set) {

		for (Pairs<Integer, Integer> pair : set) {
			System.out.println("(" + pair.getFirst() + "," + pair.getSecond() + ")");
		}
	}

	public static void main(String[] args) {

		List<Integer> songs = Arrays.asList(30, 20, 150, 100, 40);
		long playlist = playlist(songs);
		System.out.println("playlist = " + playlist);

		List<Integer> song = Arrays.asList(20, 30, 40, 100, 80, 40);
		long playlist2 = playlist(song);
		System.out.println("playlist = " + playlist2);
	}
}
