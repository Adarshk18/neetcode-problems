class Solution {
    public int characterReplacement(String s, int k) {
        int[] cnt = new int[26];
        int l=0, maxF =0, res =0;

        for(int r=0; r<s.length(); r++){
            cnt[s.charAt(r)-'A']++;
            maxF = Math.max(maxF, cnt[s.charAt(r)-'A']);

            while((r-l+1)-maxF>k){
                cnt[s.charAt(l)-'A']--;
                l++;
            }
            res = Math.max(res, r-l+1);
        }
        return res;
    }
}
