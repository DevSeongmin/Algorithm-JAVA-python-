# 간단한 탐색 문제 


def dfs(x, y):
    global cnt
    cnt += 1

    for i in range(4):
        nx = x + x_move[i]
        ny = y + y_move[i]

        if 0 <= nx < n and 0 <= ny < n and arr[ny][nx] == arr[y][x] + 1:
            dfs(nx, ny)



T = int(input())

for tc in range(1, T+1):
    n = int(input())

    arr = [list(map(int, input().split())) for _ in range(n)]

    x_move = [-1, 1, 0, 0]
    y_move = [0, 0, -1, 1]


    answer= [float('inf'), 0]

    for y in range(n):
        for x in range(n):
            cnt = 0
            dfs(x, y)
            if cnt > answer[-1]:
                answer = [arr[y][x], cnt]
            elif cnt == answer[-1] and arr[y][x] < answer[0]:
                answer = [arr[y][x], cnt]


    print(f'#{tc}', end = ' ')
    print(*answer)