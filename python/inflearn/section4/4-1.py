n, m = map(int, input().split())
l = list(map(int, input().split()))

l.sort()
i = len(l) // 2
lt = 0
rt = len(l) - 1
while(True):
    if(l[i] == m):
        break
    elif(l[i] > m):
        rt = i
        i = (i + lt) // 2
    else:
        lt = i
        i = (i + rt) // 2
print(i + 1)