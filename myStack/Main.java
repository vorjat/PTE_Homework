package myStack;

public class Main {

	public static void main(String[] args) {
		MyStack myStack = new MyStack();
		
		myStack.push(1);
		myStack.push(2);
		//myStack.resize(5);
		/*myStack.push(3);
		myStack.push(4);
		myStack.push(5);
		myStack.push(6);*/

		
		//for (int i = 0; i < myStack.getSize(); i++) {
			//System.out.println(myStack.getSize());
			//System.out.println(myStack.pop());
		System.out.println(myStack.findLastNotZero());

		//}
	}

}
