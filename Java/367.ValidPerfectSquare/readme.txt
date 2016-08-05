1. Binary search(Divide and conquer) 

Trap: 
public static void main(String[] args) {
	int a = Integer.MAX_VALUE / 2;
	int b = Integer.MAX_VALUE / 2;
	long c = a * b;
	System.out.println(c);
}

In this case even if we are assigning the product into a long variable, we still gonna get the overflowed number in c because a * b the result is an overflowed integer, so c will store the value of this overflowed integer! 

Conclusion: Never mix long and int together.