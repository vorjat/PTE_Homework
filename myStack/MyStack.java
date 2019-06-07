package myStack;

import java.nio.BufferOverflowException;
import java.util.EmptyStackException;

public class MyStack {
	public static final int MAX_CAPACITY = 10;
	private int size = 0;
	private int[] value = new int[0];

	public boolean isEmpty() {
		return size == 0;
	}

	public void push(int i) {
		if (size < MAX_CAPACITY) {
			resize(size + 1);
			value[size - 1] = i;
		} else {
			throw new BufferOverflowException();
		}
	}

	public int pop() {
		if (size == 0) {
			throw new EmptyStackException();
		} else {
			
			int temp = value[findLastNotZero()];
			resize(size - 1);
			return temp;

		}

	}

	public Integer getSize() {
		return size;
	}

	public void clear() {
		size = 0;
	}

	public void resize(int newSize) {

		int[] oldValue = value;
		int oldSize = this.size;

		if (newSize <= MAX_CAPACITY) {
			if (newSize > this.size) {
				size = newSize;
				value = new int[size];

				for (int i = 0; i < oldSize; ++i) {
					value[i] = oldValue[i];
				}

			} else if (newSize < this.size) {
				size = newSize;
				if (newSize > 0) {
					for (int i = 0; i < newSize; ++i) {
						value[i] = oldValue[i];
					}
				}
			}
		}
	}
	
	public int findLastNotZero() {
		for(int i = size-1; i >= 0; i--) {
			if (value[i] != 0) {
				return i;
			}
		}
		return -1;
	}

	public void multiplyValues(int m) {
		for (int i = 0; i<=size-1; i++) {
			value[i] = value[i] * m;
		}
		
	}

	public void addValues(int m) {
		for (int i = 0; i<=size-1; i++) {
			value[i] = value[i] + m;
		}
		
	}

	public String FindAllMyInstances(int s) {
		int count = 0;
		String places = "";
		
		for (int i = 0; i<=size-1; i++) {
			if (value[i] == s) {
				count++;
				if (places == "") {
					places = places + i;
				} else {
					places = places + ", " + i;
				}
			}
		}
		if ( count == 0) {
		return ("I do not exists in this stack");
		} else if (count == 1) {
			return ("I am on position " + places);
		} else {
			return "I am on positions " + places;
		}
	}
	
	

}