import itertools as it

n, f = map(int, input().split())
b = [1] * n
a = list(range(1, n + 1))

for i in range(1, n):
    b[i] = b[i - 1] * (n - i) / i
for tmp in it.permutations(a):
    sum = 0
    for L, x in enumerate(tmp):
        sum += x * b[L]
    if sum == f:
        print(*tmp)
        break