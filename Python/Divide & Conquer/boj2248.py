# 작성자 : 황성민
# 작성일자 : 24.01.20
# 문제 풀이 : https://blog.naver.com/steadydeveloper/223328269404


def recursion(x, y, N):
    if N == 6:
        arr[y][x] = arr[y][x+1] = arr[y][x+2] = arr[y][x+3] = arr[y][x+4] = '*'
        arr[y+1][x+1] = arr[y+1][x+3] = '*'
        arr[y+2][x+2] = '*'
        return
    
    half = N//2
    hhalf = half//2
    
    recursion(x,y,half)
    recursion(x+half, y, half)
    recursion(x+hhalf, y+hhalf, half)
    
    
N = int(input())

arr = [[" "] * 2 * N for _ in range(N)]

recursion(0,0,2*N)


for i in arr[::-1]:
    print(*i, sep = '')