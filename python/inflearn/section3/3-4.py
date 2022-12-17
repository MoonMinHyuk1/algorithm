n = int(input())
l1 = list(map(int, input().split()))
m = int(input())
l2 = list(map(int, input().split()))

idx1 = 0
idx2 = 0
answer = [0] * (len(l1) + len(l2))
for i in range(len(l1) + len(l2)):
    if(idx1 == len(l1)):
        answer[i] = l2[idx2]
        idx2 += 1
    elif(idx2 == len(l2)):
        answer[i] = l1[idx1]
        idx1 += 1
    elif(l1[idx1] <= l2[idx2]):
        answer[i] = l1[idx1]
        idx1 += 1
    elif(l1[idx1] > l2[idx2]):
        answer[i] = l2[idx2]
        idx2 += 1
print(*answer)