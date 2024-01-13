# 간단한 탐색 문제 (DFS, BFS)
# DFS로 구현

def dfs(x, y):
    global solve

    if arr[y][x] == '3':
        solve = 1
        return

    visited[y][x] = True

    for i in range(4):
        nx = x + x_move[i]
        ny = y + y_move[i]

        if 0 <= nx < 16 and 0 <= ny < 16 and not visited[ny][nx] and arr[ny][nx] != '1':
            dfs(nx, ny)

for _ in range(10):

    tc = int(input())

    arr = [list(input()) for _ in range(16)]
    visited = [[False] * 16 for _ in range(16)]

    x_move = [-1,1,0,0]
    y_move = [0,0,-1,1]

    solve = 0
    dfs(1,1)
    print(f'#{tc} {solve}')

