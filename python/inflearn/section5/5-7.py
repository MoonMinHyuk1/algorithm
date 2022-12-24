from collections import deque

cur = input()
n = int(input())

for i in range(n):
    str = input()
    q = deque(cur)
    for c in str:
        if q and c == q[0]:
            q.popleft()
        elif q and c != q[0]:
            if any(c == x for x in q):
                print("#%d NO" %(i + 1))
                break
    else:
        if q:
            print("#%d NO" %(i + 1))
        else:
            print("#%d YES" %(i + 1))