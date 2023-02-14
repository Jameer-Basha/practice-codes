s=input()
start =0
n =len(s)
res =""
front=[]
for i in range(n):
    if(s[i].isalnum()):
        front.append(s[i])
l=-1
for i in range(n):
    if(s[i].isalnum()):
        res+=front[l]
        l-=1
    else:
        res+=s[i]
print(res)
