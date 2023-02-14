input_str = list(input().split(","))
dates = []
n = len(input_str)
months = {'jan':1,'feb':2,'mar':3,'apr':4,'may':5,'jun':6,'jul':7,'aug':8,'sep':9,'oct':10,'nov':11,'dec':12}
def isIncresing(d1, d2):
    y1 = int(d1[-4:])
    y2 = int(d2[-4:])
    
    if y1<y2:
        return True
    elif y2<y1:
        return False
    
    else:
        m1 = d1[3:6]
        m2 = d2[3:6]
        m1 = months[d1[3:6].lower()]
        m2 = months[d2[3:6].lower()]
        
        if m1<m2:
            return True
        elif m2<m1:
            return False
        else:
            d1 = int(d1[:2])
            d2 = int(d2[:2])
            if d1<=d2:
                return True
            else:
                return False
index = 0
for i in input_str:
    date = i.strip()
    date = date[:3]+date[3:6].title()+date[6:]
    dates.append(date)
while (index<n-1):
    if not isIncresing(dates[index],dates[index+1]):
        dates[index],dates[index+1] = dates[index+1],dates[index]
        index = 0
    else:
        index+=1
print(", ".join(dates))
