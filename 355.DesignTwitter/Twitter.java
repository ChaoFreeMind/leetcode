import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Twitter {
    class Tweet {
   // class Tweet implements Comparable<Tweet> {
        long timestamp;
        int tweetId;
        Tweet(int tweetId, long timestamp) {
            this.tweetId = tweetId;
            this.timestamp = timestamp;
        }
        /*
        public int compareTo(Tweet tweet) {
            if(tweet.timestamp == this.timestamp) {
                return 0;
            } else if(tweet.timestamp > this.timestamp) {
                return 1;
            } else {
                return -1;
            }
        }*/
    }

    private Map<Integer, List<Tweet>> tweets;//Map the userId to all of his posts.
    private Map<Integer, Set<Integer>> followees;//Map the userId to all users he follows.
    /** Initialize your data structure here. */
    private static long timestamp = 0;

    public Twitter() {
        tweets = new HashMap<>();
        followees = new HashMap<>();

    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        //tweetId already exists or user not exists
        Tweet newTweet = new Tweet(tweetId, timestamp++);
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(newTweet);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        //PriorityQueue is default as a min-heap 
        PriorityQueue<Tweet> feeds = new PriorityQueue<>(new Comparator<Tweet>() {
            public int compare(Tweet tw1, Tweet tw2) {
                //tw2.timestamp - tw1.timestamp
                if(tw2.timestamp > tw1.timestamp) {
                    return 1;
                } else if (tw2.timestamp < tw1.timestamp) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        
        if (tweets.containsKey(userId)) {
            for(Tweet tweet: tweets.get(userId)) {
                feeds.offer(tweet);
            }
        }
        if(followees.containsKey(userId)) {
            for(int followee: followees.get(userId)) {
                if(tweets.containsKey(followee)) {
                    for(Tweet tweet: tweets.get(followee)) {
                        feeds.offer(tweet);
                    }
                }
            }
        }
        List<Integer> resList = new ArrayList<>();
        while(!feeds.isEmpty() && resList.size() < 10) {
            resList.add(feeds.poll().tweetId);
        }
        return resList;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        //follower/followee does not exist
        if (followerId == followeeId) return;//One can not follow himself
        followees.putIfAbsent(followerId, new HashSet<>());
        followees.get(followerId).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId || !followees.containsKey(followerId)) return;
        followees.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */