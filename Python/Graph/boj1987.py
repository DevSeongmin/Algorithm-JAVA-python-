# 작성자 : 황성민
# 작성날짜 : 2024.01.14
# 문제 접근 및 해결 : https://blog.naver.com/steadydeveloper/223322058174


import sys
input = sys.stdin.readline

answer =0 

# dfs 방식으로 탐색 
def dfs(y,x, depth):
    global answer 
    # 현재 깊이가 정답 보다 크다면 정답을 현재 깊이로 업데이트 
    answer = max(answer, depth)
    
    #현재 좌표의 알파벳 방문처리 
    visited.add(arr[y][x])
    
    # 상, 하, 좌, 우 방향 탐색 
    for i in range(4):
        nx = x + x_move[i]
        ny = y + y_move[i]
        
        # 만약 다음 방향이 범위 안의 좌표이고 다음 좌표의 알파벳을 아직 방문하지 않았다면 재귀적으로 탐색 
        if 0<= nx < X and 0<= ny < Y and arr[ny][nx] not in visited:
            dfs(ny,nx,depth + 1)
            
    # 함수를 빠져나올때는 현재 방문처리했던 알파벳을 다시 빼줌
    visited.remove(arr[y][x])
    
    

# 상하좌우 좌표 값     
y_move = [-1,1,0,0]
x_move = [0,0,-1,1]

# 세로(Y) 가로(X) 범위값 입력 
Y,X = map(int ,input().split())

# 알파벳값이 각각의 좌표로 들어간 2차원 리스트 생성  
arr = [list(input()) for _ in range(Y)]

# 방문처리는 셋 자료구조 이용 
visited = set()

# 시작점(0, 0) 에서 탐색 시작 
dfs(0,0,1)

# 정답 출력 
print(answer)


