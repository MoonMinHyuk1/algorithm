from collections import deque

n, m = map(int, input().split())
l = list(map(int, input().split()))

q = deque(l)
answer = 0
while q:
    m -= 1
    for i in range(1, len(q)):
        if q[0] < q[i]:
            q.append(q.popleft())
            if m == -1:
                m = len(q) - 1
            break
    else:
        if m == -1:
            answer = n - len(q) + 1
            break
        q.popleft()
print(answer)