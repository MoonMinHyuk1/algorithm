from collections import deque

n, k = map(int, input().split())

l = list(range(1, n + 1))
q = deque(l)
while len(q) != 1:
    for _ in range(1, k):
        q.append(q.popleft())
    q.popleft()
print(q[0])