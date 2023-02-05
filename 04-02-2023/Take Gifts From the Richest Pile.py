/* 
You are given an integer array gifts denoting the number of gifts in various piles. Every second, you do the following:

Choose the pile with the maximum number of gifts.
If there is more than one pile with the maximum number of gifts, choose any.
Leave behind the floor of the square root of the number of gifts in the pile. Take the rest of the gifts.
Return the number of gifts remaining after k seconds.
*/
class Solution:
    def pickGifts(self, gifts: List[int], k: int) -> int:
        lst = gifts.copy()
        lst.sort()
        lst.reverse()
        ls=[]
        count=0
        while(count<k):
                lst[0]= int(lst[0] ** (0.5))
                lst.sort()
                lst.reverse()
                count+=1
        return sum(lst)
            
    
