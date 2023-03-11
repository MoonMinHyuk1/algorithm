l = [0] * 100
l[0], l[1], l[2], l[3], l[4] = 1, 1, 1, 2, 2
for i in range(5, 100):
    l[i] = l[i - 1] + l[i - 5]

t = int(input())
for _ in range(t):
    n = int(input())
    print(l[n  - 1])