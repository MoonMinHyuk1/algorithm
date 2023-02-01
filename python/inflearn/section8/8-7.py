n = int(input())
l = [list(map(int, input().split())) for _ in range(n)]
dp = [0] * n

l.sort(key = lambda x : (-x[0], -x[2]))
dp[0] = l[0][1]
for i in range(1, n):
    h = 0
    for j in range(i - 1, -1, -1):
        if l[i][0] < l[j][0] and l[i][2] < l[j][2] and dp[j] > h:
            h = dp[j]
    dp[i] = h + l[i][1]

print(max(dp))