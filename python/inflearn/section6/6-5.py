def dfs(level, sum, tsum):
    global answer
    if sum + (total - tsum) < answer:
        return
    if sum > c:
        return
    if level == n + 1:
        if sum >= answer:
            answer = sum
        return
    dfs(level + 1, sum + l[level - 1], tsum + l[level - 1])
    dfs(level + 1, sum, tsum + l[level - 1])

c, n = map(int, input().split())
l = list(int(input()) for _ in range(n))
total = sum(l)
answer = 0

dfs(1, 0, 0)
print(answer)