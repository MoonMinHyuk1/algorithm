def solution(mid, l):
    cnt = 1 #말의 마리수
    start = l[0]
    for i in range(1, len(l)):
        if(l[i] - start >= mid):
            cnt += 1
            start = l[i]
    return cnt

n, c = map(int, input().split())
l = list(int(input()) for _ in range(n))

l.sort()
lt = 1
rt = l[len(l) - 1] - l[0]
answer = 0
while(lt <= rt):
    mid = (lt + rt) // 2
    cnt = solution(mid, l)
    if(cnt >= c):
        answer = mid
        lt = mid + 1
    else:
        rt = mid - 1
print(answer)