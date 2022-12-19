k, n = map(int, input().split())
l = list(int(input()) for _ in range(k))

lt = 1
rt = max(l)
answer = 0
while(lt <= rt):
    mid = (lt + rt) // 2
    cnt = 0
    for x in l:
        cnt += x // mid
    if(cnt >= n):
        answer = mid
        lt = mid + 1
    else:
        rt = mid - 1
print(answer)