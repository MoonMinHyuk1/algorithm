def dfs(level):
    global answer
    if level == m:
        answer += 1
        print(*l)
        return
    for i in range(1, n + 1):
        for j in range(len(l)):
            if i == l[j]:
                break
        else:
            l.append(i)
            dfs(level + 1)
            l.pop()

n, m = map(int, input().split())
l = list()
answer = 0

dfs(0)
print(answer)