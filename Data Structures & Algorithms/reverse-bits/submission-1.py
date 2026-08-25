class Solution:
    def reverseBits(self, n: int) -> int:
        res = 0
        for i in range(32):
            extract = ((n>>i)&1)
            if extract ==1:
                res |= (1<<(31-i))

        return res        
        