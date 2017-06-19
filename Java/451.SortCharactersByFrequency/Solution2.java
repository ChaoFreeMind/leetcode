public class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> charToFreq = new HashMap<>();
        Map<Integer, StringBuilder> freqToStr = new HashMap<>();

        for (char c: s.toCharArray()) {
            charToFreq.put(c, charToFreq.getOrDefault(c, 0) + 1);
        }

        for (char key: charToFreq.keySet()) {
            int val = charToFreq.get(key);
            StringBuilder sb = new StringBuilder();
            
            for (int i = 0; i < val; i++) sb.append(key);

            StringBuilder newSb = freqToStr.getOrDefault(val, new StringBuilder()).append(sb);
            freqToStr.put(val, newSb);
        }
        List<Integer> freqList = new ArrayList<>(freqToStr.keySet());
        Collections.sort(freqList, Collections.reverseOrder());

        StringBuilder result = new StringBuilder();

        for (int freq: freqList) {
            result.append(freqToStr.get(freq));
        }
    }
}