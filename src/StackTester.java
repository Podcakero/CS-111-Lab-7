public class StackTester
{

	public static void main(String[] args)
	{
		Stack<String> names = new Stack<String>(4);
		names.push("Drew");
		names.push("Steamy");
		names.push("Jay");
		System.out.println();
		System.out.println("The stack currently looks like: " + names);
		System.out.println("The top name is: " + names.pop());
		System.out.println("The stack now looks like: " + names);
		System.out.println();
		names.push("Hunter");
		names.push("Jacob");
		System.out.println();
		System.out.println("The stack currently looks like: " + names);
		System.out.println("The size is: " + names.size());
		System.out.println();
		System.out.print("The last element is: ");
		Stack.printLast(names);
		System.out.println("The stack is still: " + names);
		System.out.println();
		System.out.print("The stack reversed is: ");
		Stack.reverse(names);
		System.out.println("The stack is still: " + names);
		System.out.println();
		Stack<String> shopping = new Stack<String>();
		shopping.push("Bread");
		shopping.push("Bread");
		shopping.push("Egg");
		shopping.push("Milk");
		shopping.push("Bread");
		shopping.push("Oil");
		shopping.push("Butter");
		shopping.push("Bread");
		shopping.push("Chips");
		//shopping.push("Bread");
		System.out.println("Deleting all occurrences of \"Bread\" in " + shopping);
		Stack.deleteAll(shopping, "Bread");
		System.out.println("The stack now looks likes: " + shopping);
		System.out.println();
		Stack<String> colors = new Stack<String>();
		colors.push("Yellow");
		colors.push("Blue");
		colors.push("Orange");
		colors.push("Pink");
		colors.push("Purple");
		colors.push("Red");
		colors.push("Grey");
		colors.push("Black");
		colors.push("White");
		System.out.println("Discarding 5 elements from " + colors);
		Stack.popAndDiscard(colors, 5);
		System.out.println("The stack now looks like: " + colors);
	}


}
