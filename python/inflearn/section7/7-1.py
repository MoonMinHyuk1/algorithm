def dfs(level, score, time):
    global answer
    if level == n:
        if time <= m and score > answer:
            answer = score
        return
    if time > m:
        return
    dfs(level + 1, score + l[level][0], time + l[level][1])
    dfs(level + 1, score, time)

n, m = map(int, input().split())
l = [list(map(int, input().split())) for _ in range(n)]
answer = 0

dfs(0, 0, 0)
print(answer)