def dfs(level, sumA, sumB, sumC):
    global answer
    if level == n:
        if sumA != sumB and sumA != sumC and sumB != sumC:
            num = max(sumA, sumB, sumC) - min(sumA, sumB, sumC)
            if num < answer:
                answer = num
        return
    dfs(level + 1, sumA + l[level], sumB, sumC)
    dfs(level + 1, sumA, sumB + l[level], sumC)
    dfs(level + 1, sumA, sumB, sumC + l[level])

n = int(input())
l = list(int(input()) for _ in range(n))
answer = float('inf')

dfs(0, 0, 0, 0)
print(answer)