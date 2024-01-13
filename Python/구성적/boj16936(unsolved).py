# https://www.acmicpc.net/problem/16936

N = int(input())
arr = list(map(int, input().split()))
solve = []

solve.append(arr.pop())



while 1:
    if solve[-1] % 3 ==0 and solve[-1] // 3 in arr:
        solve.append(arr.pop(arr.index(solve[-1] // 3)))
        
    elif solve[-1] * 2 in arr:
        solve.append(arr.pop(arr.index(solve[-1] * 2)))
    
    else:
        break
    
    
while arr:
    if solve[0] % 2 == 0 and solve[0] // 2 in arr:
        solve.append(arr.pop(arr.index(solve[0] // 2)))
        
    else:
        solve.append(arr.pop(arr.index(solve[0] * 3)))

        
print(*solve)
