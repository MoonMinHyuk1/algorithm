l = []
for i in range(21):
    l.append(i)
for _ in range(10):
    a, b = map(int, input().split())
    r = l[a:b + 1]
    r.reverse()
    l[a:b + 1] = r
l.pop(0)
print(*l)