def dfs(level, sum):
    global answer
    if level > answer:
        return
    if sum == m:
        if level < answer:
            answer = level
        return
    if sum > m:
        return
    for i in range(n):
        dfs(level + 1, sum + l[i])

n = int(input())
l = list(map(int, input().split()))
m = int(input())
answer = float('inf')

l.sort(reverse = True)
dfs(0, 0)
print(answer)