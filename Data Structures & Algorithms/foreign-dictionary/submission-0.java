class Solution {
    Map<Character, Set<Character>> adj;
    Map<Character, Boolean> vis;
    List<Character> res;

    public String foreignDictionary(String[] words) {
      adj = new HashMap<>();
      for(String word: words){
        for(char c: word.toCharArray()){
            adj.putIfAbsent(c, new HashSet<>());
        }
      }

      for(int i=0; i<words.length-1; i++){
        String w1 = words[i];
        String w2 = words[i+1];

        int minLen = Math.min(w1.length(), w2.length());

        if(w1.length()>w2.length() && w1.substring(0,minLen).equals(w2.substring(0, minLen))){
            return "";
        }

        for(int j=0; j<minLen; j++){
            if(w1.charAt(j)!=w2.charAt(j)){
                adj.get(w1.charAt(j)).add(w2.charAt(j));
                break;
            }
        }
      }

      vis = new HashMap<>();
      res = new ArrayList<>();
      for(char c: adj.keySet()){
        if(dfs(c)){
            return "";
        }
      }

      Collections.reverse(res);
      StringBuilder sb = new StringBuilder();
      for(char c: res){
        sb.append(c);
      }
      return sb.toString();
    }

    private boolean dfs(char ch){
        if(vis.containsKey(ch)){
            return vis.get(ch);
        }

        vis.put(ch,true);
        for(char next: adj.get(ch)){
            if(dfs(next)){
                return true;
            }
        }

        vis.put(ch,false);
        res.add(ch);
        return false;
    }
}
