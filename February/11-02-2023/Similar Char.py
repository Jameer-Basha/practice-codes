n =int(input())
s =input()
q= int(input())
for i in range(q):
    index=int(input())
    ele =s[:index-1].count(s[index-1])
    
    print(ele)
