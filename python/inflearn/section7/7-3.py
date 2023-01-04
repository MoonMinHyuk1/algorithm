def dfs(level, sum):
    global cnt
    if level == k:
        if 0 < sum <= s:
            cnt.add(sum)
        return
    dfs(level + 1, sum + l[level])
    dfs(level + 1, sum - l[level])
    dfs(level + 1, sum)

k = int(input())
l = list(map(int, input().split()))
s = sum(l)
cnt = set()

dfs(0, 0)
print(s - len(cnt))

# # 시간초과
# def dfs(num, level, sum, water):
#     if num in cnt:
#         return
#     if sum == water:
#         cnt.add(num)
#         return
#     if level == k:
#         return
#     if ch[level] == 0:
#         ch[level] = 1
#         dfs(num, level + 1, sum + l[level], water)
#         dfs(num, level + 1, sum, water + l[level])
#         dfs(num, level + 1, sum, water)
#         ch[level] = 0

# k = int(input())
# l = list(map(int, input().split()))
# ch = [0] * k
# s = sum(l)
# cnt = set()

# for i in range(1, s + 1):
#     dfs(i, 0, 0, i)
# print(s - len(cnt))