//https://leetcode.com/problems/sort-characters-by-frequency/

public class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> charToFreq = new HashMap<>();
        for (char c: s.toCharArray()) {
        	if (charToFreq.containsKey(c)) {
        		charToFreq.put(c, charToFreq.get(c) + 1);
        	} else {
        		charToFreq.put(c, 1);
        	}
        }
        // Iterate through the map we built 
        Map<Integer, List<Character>> freqToChars = new HashMap<>();
        for (char key: charToFreq.keySet()) {
        	int value = charToFreq.get(key);
        	if (freqToChars.containsKey(value)) {
        		freqToChars.get(value).add(key);
        	} else {
        		List<Character> list = new ArrayList<>();
        		list.add(key);
        		freqToChars.put(value, list);
        	}
        }
        List freqList = new ArrayList(freqToChars.keySet());
        Collections.sort(freqList);
        StringBuilder sb = new StringBuilder();
        for (int freq: freqList) {
        	List<Character> charList = freqToChars.get(freq);
        	for (char c: charList) {
        		for (int i = 0; i < freq; i++) {
        			sb.append(c);
        		}	
        	}
        }
        return sb.toString();
    }
}