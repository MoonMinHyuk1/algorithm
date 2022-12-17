n = int(input())
l = [list(map(int, input().split())) for _ in range(n)]

answer = 0
h = n // 2
for i in range(h + 1):
    answer += l[i][h]
    for j in range(1, i + 1):
        answer += l[i][h - j]
        answer += l[i][h + j]
    if(i != h):
        answer += l[n - i - 1][h]
        for j in range(1, i + 1):
            answer += l[n - i - 1][h - j]
            answer += l[n - i - 1][h + j]
print(answer)