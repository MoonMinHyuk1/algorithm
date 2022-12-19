n = int(input())
l = list(map(int, input().split()))
m = int(input())

l.sort()
for _ in range(m):
    l[0] += 1
    l[len(l) - 1] -= 1
    l.sort()
print(l[len(l) - 1] - l[0])