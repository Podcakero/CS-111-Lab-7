public class Stack <T> implements StackInterface<T>
{
	/**
	 * The collection of elements in this stack
	 */
	private T[] elements;
	/**
	 * The top-most element in the stack
	 */
	private int top;
	/**
	 * The maximum size of the stack
	 */
	private int maxSize;
	/**
	 * The current number of elements in the stack
	 */
	private int currentSize;
	/**
	 * The default size of a stack
	 */
	private final static int defaultSize = 10;

	/**
	 * Creates a new Stack of default size
	 */
	public Stack()
	{
		this(defaultSize);
	}

	/**
	 * Creates a new stack of the given max size.
	 * @param max The maximum size of the stack
	 */
	public Stack(int max)
	{
		elements = (T[]) new Object[max];
		top = -1; //The top-most element doesn't exist
		maxSize = max;
		currentSize = 0; //There are initially 0 elements
	}

	/**
	 * Pushes an element to the top of the stack.
	 * @param element
	 */
	public void push(T element)
	{
		//If the stack isn't already full
		if (!isFull())
		{
			//Increment top, and set the value at that index to the given element
			elements[++top] = element;
			currentSize++; //Increment currentSize
		}
		else
			throw new StackException("Stack is full.");
	}

	/**
	 * Pops the top-most element in the stack and returns it. This removes the element from the stack
	 * @return The top-most element
	 */
	public T pop()
	{
		//If the stack isn't already empty
		if (!isEmpty())
		{
			currentSize--; //Decrement currentSize;
			return elements[top--]; //Grab the value at top then decrement top
		}
		else
			throw new StackException("Stack is empty");
	}

	@Override
	/**
	 * @return the current # of elements in the stack
	 */
	public int size()
	{
		return currentSize;
	}

	/**
	 * @return True if the stack is empty, false if not
	 */
	public boolean isEmpty()
	{
		return currentSize == 0;
	}

	/**
	 * @return True if the stack if full, false if not
	 */
	public boolean isFull()
	{
		return currentSize == maxSize;
	}

	@Override
	/**
	 * @return The max # of elements the stack can hold
	 */
	public int getMaxSize()
	{
		return maxSize;
	}

	@Override
	/**
	 * Prints out the stack in this format: [Element1, Element2, ...]
	 */
	public String toString()
	{
		String output = "[";

		//Do the elements from beginning to not quite the end, but in reverse order
		for (int i = currentSize - 1; i > 0; i--)
			output += elements[i] + ", ";

		//If the stack has an element left, add it to the output
		if (!isEmpty())
			output += elements[0];

		//Cap off the output
		output += "]";

		return output;
	}

	/**
	 * Prints the last element in the given Stack
	 * @param stack
	 */
	public static void printLast(Stack stack)
	{
		//Reverse the stack
		Stack reverse = new Stack(stack.size());

		for (int i = 0; i < reverse.getMaxSize(); i++)
			reverse.push(stack.pop());

		//Grab the top value in the reversed stack
		Object temp = reverse.pop();
		stack.push(temp);

		System.out.println(temp);

		//Un-reverse the stack.
		for (int i = 0; i < stack.getMaxSize() - 1; i++)
			stack.push(reverse.pop());
	}

	/**
	 * Reverses the given stack
	 * @param stack The stack to reverse
	 */
	public static void reverse(Stack stack)
	{
		Stack reverse = new Stack(stack.size());

		for (int i = 0; i < reverse.getMaxSize(); i++)
			reverse.push(stack.pop());

		System.out.println(reverse);

		for (int i = 0; i < stack.getMaxSize(); i++)
			stack.push(reverse.pop());
	}

	/**
	 * Deletes all occurrences of searchValue from stack
	 * @param stack The stack to remove from
	 * @param searchValue The value to remove
	 */
	public static void deleteAll(Stack stack, Object searchValue)
	{
		//Create a new stack of the same of # of elements in stack
		Stack newStack = new Stack(stack.size());
		int elements = 0; //Count the # of elements unchanged

		//Run through the stack
		for (int i = 0; i < stack.getMaxSize(); i++)
		{
			//Make sure the stack has elements
			if (!stack.isEmpty())
			{
				//Pop the element from the stack
				Object temp = stack.pop();

				//If it's not what we're looking for, add it to the new stack of "saved" elements, else it is discarded
				if (!temp.equals(searchValue))
				{
					newStack.push(temp);
					elements++;
				}
			}
		}

		//Refill the stack with the "saved" valuesq
		for (int i = 0; i < elements; i++)
			stack.push(newStack.pop());
	}

	/**
	 * Discards the given # of elements from the given stack
	 * @param stack The stack to remove from
	 * @param numToDiscard The # of elements to discard
	 */
	public static void popAndDiscard(Stack stack, int numToDiscard)
	{
		for (int i = 0; i < numToDiscard; i++)
			stack.pop();
	}

}
