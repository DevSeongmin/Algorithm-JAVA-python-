# https://www.acmicpc.net/problem/2304


N = int(input())

arr = [list(map(int, input().split())) for _ in range(N)]
arr.sort()

max_val = 0

    
for i in range(N):
    a,b = arr[i]
    if b >= max_val: max_val, idx = b, i
    
x_idx, high = arr[0]

solve = max_val

for i in range(1,N):
    a,b = arr[i]
    if b >= high:
        solve += (a - x_idx) * high
        x_idx = a
        high = b
    

x_idx, high = arr[-1]

for i in range(N-2, idx-1,-1):
    a,b = arr[i]
    if b >= high:
        solve += (x_idx - a) * high
        x_idx = a
        high = b
print(solve)