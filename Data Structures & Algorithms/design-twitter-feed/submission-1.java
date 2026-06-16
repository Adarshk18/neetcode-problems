class Twitter {
    private int cnt;

    private Map<Integer, List<int[]>> tweetMap;
    private Map<Integer, Set<Integer>> followMap;

    public Twitter() {
        cnt =0;
        tweetMap = new HashMap<>();
        followMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new int[]{cnt, tweetId});
        cnt--;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        followMap.putIfAbsent(userId, new HashSet<>());
        followMap.get(userId).add(userId);

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));

        for(int followeeId: followMap.get(userId)){
            if(tweetMap.containsKey(followeeId)){
                List<int[]> tweets = tweetMap.get(followeeId);
                int index = tweets.size() -1;

                int[] tweet = tweets.get(index);

                minHeap.offer(new int[]{
                    tweet[0],
                    tweet[1],
                    followeeId,
                    index-1,
                });
            }
        }


        while(!minHeap.isEmpty() && res.size()<10){
            int[] curr = minHeap.poll();

            int tweetId = curr[1];
            int followeeId = curr[2];
            int index = curr[3];

            res.add(tweetId);

            if(index>=0){
                int[] nextTweet = tweetMap.get(followeeId).get(index);

                minHeap.offer(new int[]{
                    nextTweet[0],
                    nextTweet[1],
                    followeeId,
                    index-1
                });
            }

        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId)){
            followMap.get(followerId).remove(followeeId);
        }
    }
}

