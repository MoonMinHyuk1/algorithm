def dfs(level, index, sum):
    global answer
    if level == k:
        if sum % m == 0:
            answer += 1
        return
    for i in range(index, n):
        dfs(level + 1, i + 1, sum + l[i])

n, k = map(int, input().split())
l = list(map(int, input().split()))
m = int(input())
answer = 0

dfs(0, 0, 0)
print(answer)