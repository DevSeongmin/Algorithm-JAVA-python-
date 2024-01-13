# 기존의 지뢰 주변의 수를 체크하는 문제와
# 0인 칸을 눌렀을 때 칸들과 이와 인접한 칸들이 한 번의 클릭에 연쇄적으로 숫자가 표시되도록 해야하는 문제
# (DFS,BFS) 탐색이 추가된 문제

x_move = [-1, 1, 0, 0, -1, 1, -1, 1]
y_move = [0, 0, -1, 1, -1, 1, 1, -1]
def dfs(x,y):

    if not visited[y][x]:
        visited[y][x] = True

        for i in range(8):
            nx = x_move[i] + x
            ny = y_move[i] + y

            if 0 <= nx < n and 0 <= ny < n:
                if arr[ny][nx] == 0:
                    dfs(nx, ny)
                else:
                    visited[ny][nx] = True

T = int(input())

for tc in range(1,T+1):

    n = int(input())

    arr = [list(input()) for _ in range(n)]
    arr = [[0 if j == '.' else j for j in i] for i in arr]
    visited = [[True if j =='*' else False for j in i] for i in arr]


    for y in range(n):
        for x in range(n):
            if arr[y][x] =='*':
                for i in range(8):
                    nx = x + x_move[i]
                    ny = y + y_move[i]
                    if 0 <= nx < n and 0 <= ny < n:
                        if arr[ny][nx] != '*':
                            arr[ny][nx] += 1

    zero_index = []
    for y in range(n):
        for x in range(n):
            if arr[y][x] == 0:
                zero_index.append([x, y])


    cnt = 0
    for x, y in zero_index:
        if not visited[y][x]:
            cnt += 1
            dfs(x,y)

    print(f'#{tc} {sum(map(lambda x: n - sum(x), visited)) + cnt}')