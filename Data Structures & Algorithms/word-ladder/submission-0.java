class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }
        Map<String, List<String>> nei = new HashMap<>();
        wordList.add(beginWord);

        for(String word: wordList){
            for(int i=0; i<word.length(); i++){
                String pattern = word.substring(0,i)+ "*" + word.substring(i+1);
                nei.computeIfAbsent(pattern , k->new ArrayList<>()).add(word);
            }
        }

        Queue<String> q = new LinkedList<>();
        Set<String> vis = new HashSet<>();

        q.offer(beginWord);
        vis.add(beginWord);

        int res = 1;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0; i<size; i++){
                String word = q.poll();

                if(word.equals(endWord)){
                    return res;
                }

                for(int j=0; j<word.length(); j++){
                    String pattern = word.substring(0,j)+ "*" + word.substring(j+1);
                    List<String> neighbours = nei.getOrDefault(pattern, new ArrayList<>());

                    for(String nb: neighbours){
                        if(!vis.contains(nb)){
                            vis.add(nb);
                            q.offer(nb);
                        }
                    }
                }
            }
            res++;
        }
        return 0;

    }
}
