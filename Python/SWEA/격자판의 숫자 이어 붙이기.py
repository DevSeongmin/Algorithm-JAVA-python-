def dfs(x, y, s):

    global check_set
    s += str(arr[y][x])
    if len(s) == 7:
        check_set.add(s)
        return

    for i in range(4):
        nx = x + x_move[i]
        ny = y + y_move[i]

        if 0 <= nx < 4 and 0 <= ny < 4:
            dfs(nx, ny, s)



T = int(input())
for tc in range(1, T+1):

    arr = [list(map(int, input().split())) for _ in range(4)]
    check_set = set()
    x_move = [1, -1, 0, 0]
    y_move = [0, 0, 1, -1]

    for i in range(4):
        for j in range(4):
            dfs(i,j, '')

    print(f'#{tc} {len(check_set)}')