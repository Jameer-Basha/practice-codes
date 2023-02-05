''' Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1 '''
class Solution:
    def firstUniqChar(self, s: str) -> int:
        ans = ''
        for i in s :
            if (s.count(i)==1):
                ans =i 
                break 
        if(ans ==''):
            res = -1
        else : 
            res=s.index(ans)
        return res
