from collections import deque

T = int(input())

for test_case in range(1, T + 1):
    n = int(input())

    arr = [list(map(int, input())) for _ in range(n)]
    # 해당 위치 까지 걸리는 시간을 담을 time 리스트 선언 값을 무한으로 하여 방문 확인 리스트를 따로 만들지 않음
    time = [[float('inf')] * n for _ in range(n)]
    time[0][0] = 0
    queue = deque([[0, 0]])

    x_move = [-1, 1, 0, 0]
    y_move = [0, 0, -1, 1]

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x + x_move[i]
            ny = y + y_move[i]
            # 해당 인덱스가 n,n 범위 안에 있으면서 이전 인덱스의 타임 값 + 현재 인덱스의 리스트의 값이 현재 인덱스 time에 담겨있는거 보다 작으면 초기화 후 큐에 넣어줌
            if 0 <= nx < n and 0 <= ny < n and time[y][x] + arr[ny][nx] < time[ny][nx]:
                time[ny][nx] = time[y][x] + arr[ny][nx]
                queue.append([nx, ny])

    print(f'#{test_case} {time[-1][-1]}')
