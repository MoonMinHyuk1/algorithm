n, w = map(int, input().split())
l = [list(map(int, input().split())) for _ in range(n)]
dp = [0] * (w + 1)

l.sort(key = lambda x : (x[0], -x[1]))
for i in range(l[0][0], w + 1):
    for j in range(n):
        if i < l[j][0]:
            break
        if dp[i] < dp[i - l[j][0]] + l[j][1]:
            dp[i] = dp[i - l[j][0]] + l[j][1]
print(dp[w])