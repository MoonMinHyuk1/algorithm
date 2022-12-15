def reverse(x):
    sum = 0
    while(x != 0):
        sum *= 10
        sum += x % 10
        x //= 10
    return sum

def isPrime(x):
    if(x == 1):
        return False
    for i in range(2, x):
        if(x % i == 0):
            return False
    return True

n = int(input())
l = list(map(int, input().split()))

for i in l:
    num = reverse(i)
    if(isPrime(num) == True):
        print(num, end=" ")