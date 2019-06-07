package myStack;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.BufferOverflowException;
import java.util.EmptyStackException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class MyStackTest {
	MyStack myStack;
	
	@BeforeEach
	public void setUp() throws Exception {
		myStack = new MyStack();
	}
	
		@Test
		public void newlyCreatedStackIsEmpty() {
			assertTrue(myStack.isEmpty());
		}
		
		@Test
		public void afterPushStackNotEmpty() {
			myStack.push(1);
			assertFalse(myStack.isEmpty());
			assertTrue(!myStack.isEmpty());
		}
		
		@Test
		public void afterPushAndPopStackEmpty() {
			myStack.push(1);
			myStack.pop();
			assertTrue(myStack.isEmpty());
		}
		
		@Test
		public void emptyStackThrowsOnPop() {
			assertThrows(EmptyStackException.class, ()->myStack.pop());
		}
		
		@Test
		public void popReturnsWhatWasPushed() {
			myStack.push(1);
			assertEquals(myStack.pop(), 1);
		}
		
		@Test
		public void stackNotEmptyWhenLessPopThanPush () {
			myStack.push(1);
			myStack.push(9);
			myStack.pop();
			assertFalse(myStack.isEmpty());
		}
		
		@Test
		public void lastPopReturnLastPushedValue() {
			myStack.push(1);
			myStack.push(9);
			assertEquals(myStack.pop(), 9);
		}
		
		@Test
		public void stackThrowsWhenCapacityExceeded() {
			assertThrows(BufferOverflowException.class,
			()->{
				for (int i = 0; i<MyStack.MAX_CAPACITY+1; ++i) 
				myStack.push(i);	 
			});
		}
		
		@Test
		public void showZeroSizeIfEmpty() {
			assertEquals(myStack.getSize(), 0);
		}
		@Test
		public void showZeroSizeIfNotEmpty() {
			myStack.push(5);
			myStack.push(10);
			assertEquals(myStack.getSize(), 2);
		}
		
		@Test
		public void ifClearWorksForEmpty() {
			myStack.clear();
			assertEquals(myStack.getSize(), 0);
		}
		@Test
		public void ifClearWorksForNotEmpty() {
			myStack.push(5);
			myStack.push(10);
			myStack.clear();
			assertEquals(myStack.getSize(), 0);
		}
		
		@Test
		public void ifSizingUpWorks() {
			myStack.push(1);
			myStack.push(2);
			myStack.resize(5);
			assertEquals(myStack.getSize(), 5);
			assertEquals(myStack.pop(), 2);
		}
		
		@Test
		public void returnMinusOneIfEmpty() {
			assertEquals(myStack.findLastNotZero(), -1);
		}
		
		@Test
		public void ifSizingDownWorks() {
			myStack.push(1);
			myStack.push(2);
			myStack.push(3);
			myStack.push(4);
			myStack.resize(2);
			assertEquals(myStack.pop(), 2);
		}
		
		@Test
		public void TestMultiply() {
			myStack.push(1);
			myStack.push(2);
			myStack.multiplyValues(3);
			assertEquals(myStack.pop(), 6);
			assertEquals(myStack.pop(), 3);
		}
		
		@Test
		public void TestAdd() {
			myStack.push(1);
			myStack.push(2);
			myStack.addValues(10);
			assertEquals(myStack.pop(), 12);
			assertEquals(myStack.pop(), 11);
		}
		
		
		@Test
		public void TestFindAllMyInstancesNoInstance() {
			myStack.push(1);
			myStack.push(2);
			assertEquals(myStack.FindAllMyInstances(3), "I do not exists in this stack");
		}
		
		@Test
		public void TestFindAllMyInstancesOneInstance() {
			myStack.push(1);
			myStack.push(2);
			assertEquals(myStack.FindAllMyInstances(1), "I am on position 0");
		}
		
		@Test
		public void TestFindAllMyInstancesManyInstances() {
			myStack.push(1);
			myStack.push(2);
			myStack.push(1);
			myStack.push(1);
			myStack.push(2);
			assertEquals(myStack.FindAllMyInstances(2), "I am on positions 1, 4");
		}
}