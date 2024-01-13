# https://www.acmicpc.net/problem/18185


# 문제는 그리디하게 교환의 횟수를 최소로 하면 된다.
# 하지만 1 2 1 1  같이 처음에 3개를 이어서 구매하는경우 
# 0 1 0 1 로 떨어지게 되어 최적해가 되지않는다 
# 이와 같이 끊어지지않도록 구현하는것이 중요하다.

n = int(input())

arr = list(map(int, input().split()))[::-1]
solve = 0
start = n-1


for i in range(n-1, -1, -1):
    if arr[i-1] > arr[i-2]:
        m = min(arr[i-1] - arr[i-2], arr[i])
        solve += m * 5
        arr[i] -= m
        arr[i-1] -= m
        
    if arr[i] > 0 and arr[i-1] > 0 and arr[i-2] > 0:
        m = min(arr[i], arr[i-1])
        solve += m * 7
        arr[i] -= m
        arr[i-1] -= m
        arr[i-2] -= m
        
    if arr[i] > 0:
        solve += 3 * arr[i]
        arr[i] = 0

    

print(solve)
