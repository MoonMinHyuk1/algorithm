def dfs(l, level, n):
    if level == n + 1:
        if l:
            print(*l)
        return
    l.append(level)
    dfs(l, level + 1, n)
    l.remove(level)
    dfs(l, level + 1, n)

n = int(input())
dfs([], 1, n)

# 전역변수a
# n = int(input())
# l = list()

# def dfs(level):
#     if level == n + 1:
#         if l:
#             print(*l)
#         return
#     l.append(level)
#     dfs(level + 1)
#     l.remove(level)
#     dfs(level + 1)

# dfs(1)