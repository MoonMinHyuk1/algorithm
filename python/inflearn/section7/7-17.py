def dis_pizza():
    dis = [[float('inf')] * n for _ in range(n)]
    for i in range(m):
        for j in range(len(house)):
            distance = abs(pizza_select[i][0] - house[j][0]) + abs(pizza_select[i][1] - house[j][1])
            if distance < dis[house[j][0]][house[j][1]]:
                dis[house[j][0]][house[j][1]] = distance
    sum = 0
    for i in range(len(house)):
        sum += dis[house[i][0]][house[i][1]]
    return sum

def dfs_combi(level, index):
    global answer
    if level == m:
        sum = dis_pizza()
        if sum < answer:
            answer = sum
        return
    for i in range(index, len(pizza)):
        pizza_select[level] = pizza[i]
        dfs_combi(level + 1, i + 1)

n, m = map(int, input().split())
g = [list(map(int, input().split())) for _ in range(n)]
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
house = []
pizza = []
pizza_select = [(0, 0) for _ in range(m)]
answer = float('inf')

for i in range(n):
    for j in range(n):
        if g[i][j] == 2:
            pizza.append((i, j))
        elif g[i][j] == 1:
            house.append((i, j))
dfs_combi(0, 0)
print(answer)

# # 시간 초과 코드
# def dfs_pizza(x, y, level):
#     for i in range(4):
#         nx = x + dx[i]
#         ny = y + dy[i]
#         if 0 <= nx < n and 0 <= ny < n and ch[nx][ny] == 0:
#             ch[nx][ny] = 1
#             if g[nx][ny] == 1 and dis[nx][ny] > level:
#                 dis[nx][ny] = level
#             dfs_pizza(nx, ny, level + 1)
#             ch[nx][ny] = 0

# def dfs_combi(level, index):
#     global dis
#     global answer
#     global ch
#     if level == m:
#         dis = [[float('inf')] * n for _ in range(n)]
#         ch = [[0] * n for _ in range(n)]
#         for i in range(m):
#             dfs_pizza(pizza_select[i][0], pizza_select[i][1], 1)
#         sum = 0
#         for i in range(len(house)):
#             sum += dis[house[i][0]][house[i][1]]
#         if sum < answer:
#             answer = sum
#         return
#     for i in range(index, len(pizza)):
#         pizza_select[level] = pizza[i]
#         dfs_combi(level + 1, i + 1)

# n, m = map(int, input().split())
# g = [list(map(int, input().split())) for _ in range(n)]
# dis = [[float('inf')] * n for _ in range(n)]
# ch = [[0] * n for _ in range(n)]
# dx = [0, 0, 1, -1]
# dy = [1, -1, 0, 0]
# house = []
# pizza = []
# pizza_select = [(0, 0) for _ in range(m)]
# answer = float('inf')

# for i in range(n):
#     for j in range(n):
#         if g[i][j] == 2:
#             pizza.append((i, j))
#         elif g[i][j] == 1:
#             house.append((i, j))
# dfs_combi(0, 0)
# print(answer)