N = int(input())

arr = [[" "] * N for _ in range(N)]

def recursion(y,x, n):
    if n == 1:
        arr[y][x] = "*"
        return

    for i in range(y, y+n, n//3):
        for j in range(x, x+n, n//3):
            
            if (i == (y+ n//3)) and (j == (x + n//3)):
                continue
            recursion(i,j,n//3)

recursion(0,0,N)

for i in arr:
    print(*i, sep = '')