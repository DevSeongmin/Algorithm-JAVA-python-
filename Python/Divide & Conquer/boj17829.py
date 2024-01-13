def recursion(y,x,N):
    lu = arr[y][x] 
    ru = arr[y][x+1] 
    lb = arr[y+1][x] 
    rb = arr[y+1][x+1]
    
    if N > 2:
        lu = recursion(y,x, N//2)
        ru = recursion(y,x + N//2, N//2)
        lb = recursion(y + N//2,x, N//2)
        rb = recursion(y + N//2,x + N//2, N//2)


    return sorted([lu,ru,lb,rb])[2]
    

N = int(input())

arr = [list(map(int, input().split())) for _ in range(N)]

print(recursion(0,0,N))