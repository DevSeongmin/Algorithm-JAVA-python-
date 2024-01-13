from collections import deque

# BFS를 변형 시켜 문제 해결 
for tc in range(1, int(input()) + 1):


    n = int(input())
    arr = [list(map(int ,input().split())) for _ in range(n)]

    visited = [[float('inf')] * n for _ in range(n)]
    visited[0][0] = 0

    x_move = [-1, 1, 0, 0]
    y_move = [0, 0, -1, 1]

    queue = deque()
    queue.append([0, 0, 0])

    while queue:
        y,x,depth = queue.popleft()
        for i in range(4):
            nx = x + x_move[i]
            ny = y + y_move[i]
            if 0 <= nx < n and 0 <= ny < n:
                
                # 현재 좌표에서 경사의 차이 만큼 더해주고 이동 횟수 +1 해준거 보다 다음 좌표의 값이 더 크다면 
                # 현재 좌표에서 경사의 차이 만큼 더해주고 이동 횟수 +1을 다음 좌표에 넣어주고 
                # 큐에 다음 좌표와 이동 거리 (depth)를 넣어줌 
                if visited[ny][nx] > visited[y][x] + max(arr[ny][nx] - arr[y][x], 0) + 1:
                    visited[ny][nx] = visited[y][x] + max(arr[ny][nx] - arr[y][x], 0) + 1
                    queue.append([ny,nx, depth+1])


    print(f'#{tc} {visited[-1][-1]}')
    
    
    
    