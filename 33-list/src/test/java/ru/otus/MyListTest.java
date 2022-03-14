package ru.otus;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings({"ConstantConditions", "ResultOfMethodCallIgnored"})
class MyListTest {
	private final MyList<Integer> list = new MyList<>();

	private void check(Integer ... expected) {
		assertEquals(expected.length, list.size());
		for (int i = 0; i < expected.length; ++i)
			assertEquals(expected[i], list.get(i), "element at " + i);

		int j = 0;
		for (var e : list) {
			assertEquals(expected[j], e, "element at " + j + " through iterator");
			j += 1;
		}
	}

	@Test
	void emptyList() {
		assertTrue(list.isEmpty());
		assertEquals(0, list.size());
	}

	@Test
	void addSomeElements() {
		list.add(1);
		assertFalse(list.isEmpty());
		assertEquals(1, list.size());

		list.add(2);
		assertEquals(2, list.size());

		check(1, 2);
	}

	@Test
	void addManyElements() {
		for (int i = 0; i < 10000; ++i) {
			list.add(i);
		}
		assertEquals(10000, list.size());

		for (int i = 0; i < 10000; ++i) {
			assertEquals(i, list.get(i), "element at " + i);
		}
	}

	@Test
	void getInvalidIndex() {
		list.add(1);
		assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
		assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
	}

	@Test
	void clear() {
		list.add(1);
		list.add(2);
		list.clear();
		assertTrue(list.isEmpty());
		assertEquals(0, list.size());
	}

	@Test
	void set() {
		list.add(1);
		list.add(2);
		list.set(1, 42);
		check(1, 42);
	}

	@Test
	void iterator_when_listIsEmpty() {
		var it = list.iterator();
		assertFalse(it.hasNext());
		assertThrows(NoSuchElementException.class, it::next);
	}

	@Test
	void iterator_when_listIsNonEmpty() {
		list.add(1);
		list.add(2);
/*		Iterator<Integer> it = list.iterator();

		Iterator<Integer> it2 = list.iterator();

		assertTrue(it.hasNext());
		assertEquals(1, it.next());
		assertEquals(1, it2.next());
		assertEquals(2, it.next());
		assertFalse(it.hasNext());
		assertTrue(it2.hasNext());
*/
		for (var e : list) {
			System.out.println(e);
		}
	}
}