import sys
sys.setrecursionlimit(100000)

def dfs(x, y, cnt):
    global answer
    answer = max(answer, cnt)
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if nx >= 0 and nx < r and ny >= 0 and ny < c:
            index = ord(l[nx][ny]) - ord('A')
            if ch[index] == 0:
                ch[index] = 1
                dfs(nx, ny, cnt + 1)
                ch[index] = 0

r, c = map(int, input().split())
l = [list(input()) for _ in range(r)]
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
ch = [0] * 26
ch[ord(l[0][0]) - ord('A')] = 1
answer = 1

dfs(0, 0, answer)
print(answer)