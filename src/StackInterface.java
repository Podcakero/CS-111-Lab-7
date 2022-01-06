public interface StackInterface<T>
{
	public boolean isFull();
	// determines whether the stack is full.
	// Precondition:  None.
	// Postcondition:  returns true if the stack is full, and false otherwise.

	public boolean isEmpty();
// determines whether the stack is empty.
// Precondition:  None.
// Postcondition:  returns true if the stack is empty, and false otherwise.

	public void push(T newValue);
// adds a new value to the top of the stack
// Preconditions:  none.
// Postconditions:  NewValue is inserted at the top of the stack

	public T pop();
// retrieves the value at the top of the stack
// Precondition:  The stack must not be empty.
// Postconditon:  If the stack is not empty, the value at the top of the stack
//______is returned.
//_Errors:  returns null if called with an empty stack.

	public int size();
//  returns the number of elements in the stack.
// Preconditions:  NONE;
// Postconditions:  None;


	public int getMaxSize();
//  returns the maximum # of elements the stack can contain.
// Preconditions:  NONE;
// Postconditions:  None;


	public String toString();
//  returns a String containing the stack elements from top to bottom
// Preconditions:  NONE;
// Postconditions:  None;

}