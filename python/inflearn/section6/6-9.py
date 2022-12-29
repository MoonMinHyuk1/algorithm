import sys

def dfs(level):
    if level == n:
        sum = 0
        for i in range(n):
            sum += (pat[i] * l[i])
        if sum == f:
            print(*l)
            sys.exit(0)
        return
    for i in range(1, n + 1):
        if ch[i] == 0:
            ch[i] = 1
            l[level] = i
            dfs(level + 1)
            ch[i] = 0

n, f = map(int, input().split())
ch = [0] * (n + 1)
l = [0] * n
pat = [0] * n

pat[0] = 1
for i in range(1, n):
    pat[i] = pat[i - 1] * (n - i) // i
dfs(0)