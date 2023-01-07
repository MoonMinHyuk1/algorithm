from collections import deque

def bfs():
    cnt = 0
    while dq:
        for _ in range(len(dq)):
            now = dq.popleft()
            if now == e:
                dq.clear()
                return cnt
            for i in (1, -1, 5):
                if 1 <= now + i <= 10000 and ch[now + i] == 0:
                    ch[now + i] = 1
                    dq.append(now + i)
        cnt += 1

s, e = map(int, input().split())
dq = deque()
ch = [0] * 10001

ch[s] = 1
dq.append(s)

print(bfs())