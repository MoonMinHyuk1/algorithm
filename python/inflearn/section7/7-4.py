def dfs(level, sum):
    global answer
    if sum > t:
        return
    if level == k:
        if sum == t:
            answer += 1
        return
    for i in range(l[level][1] + 1):
        dfs(level + 1, sum + l[level][0] * i)

t = int(input())
k = int(input())
l = [list(map(int, input().split())) for _ in range(k)]
answer = 0

dfs(0, 0)
print(answer)