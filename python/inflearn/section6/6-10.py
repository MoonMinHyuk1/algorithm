def dfs(level, index):
    global cnt
    if level == m:
        cnt += 1
        print(*l)
        return
    for i in range(index, n + 1):
            l[level] = i
            dfs(level + 1, i + 1)
        
n, m = map(int, input().split())
l = [0] * m
cnt = 0

dfs(0, 1)
print(cnt)