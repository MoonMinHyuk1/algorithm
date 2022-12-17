n, m = map(int, input().split())
l = list(map(int, input().split()))

sum = l[0]
answer = 0
lt = 0
rt = 1
while(True):
    if(sum < m):
        if(rt < n):
            sum += l[rt]
            rt += 1
        else:
            break
    elif(sum == m):
        answer += 1
        sum -= l[lt]
        lt += 1
    else:
        sum -= l[lt]
        lt += 1
        
print(answer)