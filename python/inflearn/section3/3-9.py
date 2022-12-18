n = int(input())
l = [list(map(int, input().split())) for _ in range(n)]
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

answer = 0
for i in range(n):
    for j in range(n):
        for k in range(4):
            nx = i + dx[k]
            ny = j + dy[k]
            if((nx >= 0) and (nx < n) and (ny >= 0) and (ny < n)):
                if(l[i][j] <= l[nx][ny]):
                    break
        else:
            answer += 1
print(answer)