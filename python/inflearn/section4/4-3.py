def solution(mid, l):
    cnt = 1
    sum = 0
    for x in l:
        sum += x
        if sum > mid:
            sum = x
            cnt += 1
    return cnt

n, m = map(int, input().split())
l = list(map(int, input().split()))

lt = 0
rt = sum(l)
max = max(l)
answer = 0
while(lt <= rt):
    mid = (lt + rt) // 2
    cnt = solution(mid, l)
    if(mid >= max and cnt <= m):
        answer = mid
        rt = mid - 1
    else:
        lt = mid + 1
print(answer)