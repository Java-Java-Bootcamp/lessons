import java.util.ArrayList;
import java.util.List;

public class Lsp1 {
	/**
	 * @param iterable Мутабельная коллекция
	 */
	private static void removeEven(Iterable<Integer> iterable) {
		for (var it = iterable.iterator(); it.hasNext();) {
			if (it.next() % 2 == 0) {
				it.remove();
			}
		}
	}

	public static void main(String[] args) {
		var list1 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(2);
		removeEven(list1); // 1

		removeEven(List.of(1, 3)); // 2

		//removeEven(List.of(1, 2)); // 3
	}
}
