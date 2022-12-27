def dfs(level):
    global cnt
    if level == m:
        print(*l)
        cnt += 1
        return
    for i in range(1, n + 1):
        l.append(i)
        dfs(level + 1)
        l.pop()

n, m = map(int, input().split())
l = list()
cnt = 0

dfs(0)
print(cnt)