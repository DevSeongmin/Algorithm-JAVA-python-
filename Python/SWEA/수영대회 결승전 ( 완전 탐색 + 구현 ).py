from collections import deque
from copy import deepcopy

def dfs(y, x, arr_t):
    if [y,x] == end:
        return True
    
    arr_t[y][x] = 1
    
    for i in range(4):
        ny = y_move[i] + y
        nx = x_move[i] + x
        if 0 <= nx < N and 0 <= ny < N and arr_t[ny][nx] != 1:
            return dfs(ny, nx, arr_t)
    return False

x_move = [1, 0, -1, 0, 0]
y_move = [0, -1, 0, 1, 0]

T = int(input())


for tc in range(1, T+1):
    N = int(input())
    arr = [list(map(int, input().split())) for _ in range(N)]

    start = list(map(int, input().split()))
    end = list(map(int, input().split()))

    arr_t = deepcopy(arr)
    check = dfs(start[0], start[1], arr_t)

    if not check:
        print(f"#{tc} -1")
        break
    
    Q = deque()
    Q.append(start + [0])

    while Q:
        *direct, time = Q.popleft()
        if direct == end:
            print(f"#{tc} {time}")
            break
        for i in range(5):
            ny = direct[0] + y_move[i]
            nx = direct[1] + x_move[i]
            
            if 0 <= nx < N and 0 <= ny < N:
                if arr[ny][nx] == 0:
                    Q.append([ny, nx, time + 1])
                elif arr[ny][nx] == 2 and time % 3 == 2:
                    Q.append([ny,nx, time + 1])
                    
