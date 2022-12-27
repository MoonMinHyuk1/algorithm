def dfs(level):
    if level == n + 1:
        sum1 = 0
        sum2 = 0
        for i in range(n):
            if ch[i] == 0:
                sum1 += l[i]
            elif ch[i] == 1:
                sum2 += l[i]
        if sum1 == sum2:
            global answer
            answer = "YES"
        return
    ch[level - 1] = 1
    dfs(level + 1)
    ch[level - 1] = 0
    dfs(level + 1)

n = int(input())
l = list(map(int, input().split()))
ch = [0] * n
answer = "NO"

dfs(1)
print(answer)