package ru.otus;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class MyList<E> implements List<E> {
	private Object[] data = new Object[5];
	private int size;

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean add(E e) {
		if (data.length == size) {
			data = Arrays.copyOf(data, (int) (data.length * 1.5));
		}

		data[size++] = e;
		return true;
	}

	@Override
	public void clear() {
		for (int i = 0; i < size; ++i)
			data[i] = null;
		size = 0;
	}

	@Override
	public E get(int index) {
		if (index >= size || index < 0)
			throw new IndexOutOfBoundsException(index + " >= " + size);
		//noinspection unchecked
		return (E) data[index];
	}

	@Override
	public E set(int index, E element) {
		if (index >= size || index < 0)
			throw new IndexOutOfBoundsException(index + " >= " + size);
		var prev = data[index];
		data[index] = element;
		//noinspection unchecked
		return (E) prev;
	}

	@Override
	public boolean contains(Object o) {
		for (var e : this)
			if (Objects.equals(e, o))
				return true;
		return false;
	}

	private class MyListIterator implements Iterator<E> {
		int pos;

		@Override
		public boolean hasNext() {
			return pos < size();
		}

		@Override
		public E next() {
			if (!hasNext()) throw new NoSuchElementException();
			//noinspection unchecked
			return (E) data[pos++];
		}
	}

	@Override
	public Iterator<E> iterator() {
		int xx = 2;
		return new Iterator<>() {
			int pos;

			@Override
			public boolean hasNext () {
				return pos < size() && xx == 2;
			}

			@Override
			public E next () {
				if (!hasNext()) throw new NoSuchElementException();
				//noinspection unchecked
				return (E) data[pos++];
			}
		};
	}

	@Override
	public Object[] toArray() {
		return Arrays.copyOf(data, size);
	}

	@Override
	public <T> T[] toArray(T[] a) {

		throw new UnsupportedOperationException();
	}

	@Override
	public boolean remove(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void add(int index, E element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public E remove(int index) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int indexOf(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int lastIndexOf(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ListIterator<E> listIterator() {
		throw new UnsupportedOperationException();
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		throw new UnsupportedOperationException();
	}
}
