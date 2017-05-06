// Index counter solution:
// Use a counter as index to store the incoming longUrls.
// The time complexity would be O(1) and space would be O(n) where n is the total
// length longUrls that has been stored.
// The downside of this method is that the number of longUrl is limited by the limit of long type in
// java.

public class Codec {

    private long idx = LONG.MIN_VALUE;
    Map<Long, String> map = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        idx++;
        map.put(idx, longUrl);
        return String.valueOf(idx);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(Long.parseLong(shortUrl));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));