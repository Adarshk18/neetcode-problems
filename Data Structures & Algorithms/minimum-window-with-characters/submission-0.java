class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();

        int l=0,r=0,cnt=0;
        int minLen = Integer.MAX_VALUE;
        int startIndx = -1;

        int[] hash = new int[256];

        for(int i=0; i<m; i++){
            hash[t.charAt(i)]++;
        }

        while(r<n){
            char ch = s.charAt(r);

            if(hash[ch]>0) cnt++;
            hash[ch]--;

            while(cnt==m){
                if(r-l+1 < minLen){
                    minLen = r-l+1;
                    startIndx = l;
                }
                char leftChar = s.charAt(l);
                hash[leftChar]++;

                if(hash[leftChar]>0) cnt--;
                l++;
            }
            r++;
        }
        return startIndx == -1 ? "" : s.substring(startIndx, startIndx+minLen);
    }
}
