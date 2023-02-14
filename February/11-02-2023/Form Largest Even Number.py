s=input()
ls=[]
for i in s:
    if(i.isdigit()):
        ls.append(int(i))
ls=list(set(ls))
small=1
for i in ls:
    if(i%2==0):
        small=i
        break;
if(small%2==0):
    ls.remove(small)
    res ="".join(str(i) for i in ls )
    res=res[::-1]
    res+=str(small)
    print(int(res))
else:
    print(-1)
