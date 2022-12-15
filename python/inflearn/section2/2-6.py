def digit_sum(x):
    sum = 0
    while(x != 0):
        sum += x % 10
        x = x // 10
    return sum


n = int(input())
l = list(map(int, input().split()))

max = 0
for num in l:
    if(max < digit_sum(num)):
        max = digit_sum(num)
        answer = num
print(answer)