x_move = [0, 1, 1, -1]
y_move = [1, 0, 1, 1]

def dfs(y,x, depth,direction):
    global answer

    if board[y][x] == '.':
        return

    if depth == 4:
        answer = "YES"
        return

    ny = y + y_move[direction]
    nx = x + x_move[direction]
    if 0 <= nx < n and 0 <= ny < n:
        dfs(ny,nx,depth + 1, direction)


for tc in range(1, int(input()) + 1):

    n = int(input())

    board = [list(input()) for _ in range(n)]

    answer = 'NO'

    for i in range(n):
        for j in range(n):
            if board[i][j] == 'o':
                dfs(i, j, 0, 0)
                dfs(i, j, 0, 1)
                dfs(i, j, 0, 2)
                dfs(i, j, 0, 3)
    print(f'#{tc} {answer}')