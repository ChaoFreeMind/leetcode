import java.util.ArrayList;
import java.util.List;

public class Codec {
	
	public static void main(String[] args) {
		
		Codec cc = new Codec();
		
		String s = "";
		System.out.println(s.substring(0, 0).equals(""));
		
	}
	
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
    	StringBuilder sb = new StringBuilder();
    	
    	for(String s: strs) {
    		sb.append(s.length()).append("/").append(s);
    	}
    	
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
    	
    	int i = 0;
    	List<String> strs = new ArrayList<>();
    	while(i < s.length()) {
    		
    		int slash = s.indexOf('/', i);
    		int slen = Integer.parseInt(s.substring(i, slash));
    		strs.add(s.substring(slash + 1, slash + 1 + slen));
    		i = slash + slen + 1;
    	}
    	
        return strs;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));