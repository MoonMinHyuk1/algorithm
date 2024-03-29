def Qsort(lt, rt):
    if lt < rt:
        pivot = arr[rt]
        pos = lt
        for i in range(lt, rt):
            if arr[i] <= pivot:
                arr[i], arr[pos] = arr[pos], arr[i]
                pos += 1
        arr[rt], arr[pos] = arr[pos], arr[rt]
        
        Qsort(lt, pos - 1)
        Qsort(pos + 1, rt)

arr = [45, 21, 23, 36, 15, 67, 11, 60, 20, 33]
print("Before sort :", arr)
Qsort(0, 9)
print("After sort :", arr)