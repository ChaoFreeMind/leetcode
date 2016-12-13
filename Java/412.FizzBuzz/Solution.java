public class Solution {

	private String fizz = "Fizz";
	private String buzz = "Buzz";
	private String fizzBuzz = "FizzBuzz";

    public List<String> fizzBuzz(int n) {
    	List<String> res = new LinkedList<>();
    	for (int i = 1; i <= n ; i++) {
    		if (i % 3 == 0 && i % 5 == 0) {
    			res.add(fizzBuzz);
    		} else if (i % 3 == 0) {
    			res.add(fizz);
    		} else if (i % 5 == 0) {
    			res.add(buzz);
    		} else {
    			res.add(String.valueOf(i));
    		}
    	}

    	return res;
    }

    // Without using modular
    public List<String> fizzBuzz2(int n) {
    	List<String> res = new LinkedList<>();
    	int fizz = 0, buzz = 0;
    	
    	for (int i = 1; i <= n; i++) {
    		fizz++;
    		buzz++;
    		if (fizz == 3 && buzz == 5) {
    			res.add("FizzBuzz");
    			fizz = 0;
    			buzz = 0;
    		} else if (fizz == 3) {
    			res.add("Fizz");
    			fizz = 0;
    		} else if (buzz == 5) {
    			res.add("Buzz");
    			buzz = 0;
    		} else {
    			res.add(String.valueOf(i));
    		}
    	}

    	return res;
    }

}