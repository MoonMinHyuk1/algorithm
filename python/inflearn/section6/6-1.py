def dfs(n):
    if n == 0:
        return
    dfs(n // 2)
    print(n % 2, end = '')

n = int(input())
dfs(n)