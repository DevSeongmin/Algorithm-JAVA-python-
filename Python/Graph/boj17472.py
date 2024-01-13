import sys
from _heapq import heappush, heappop

input = sys.stdin.readline
sys.setrecursionlimit(10**6)


# 유니온 파인드 함수 정의 
def find(a):
    if a == check_set[a]:
        return a
    check_set[a] = find(check_set[a])
    return check_set[a]


def union(a,b):
    a,b = find(a), find(b)
    if a != b:
        check_set[b] = a
        
# 섬들을 구분하기위한 DFS
x_move = [1, 0, -1, 0]
y_move = [0, 1, 0, -1]

def dfs(y,x):
    if graph[y][x] == -1:
        graph[y][x] = cnt
    for i in range(4):
        ny = y + y_move[i]
        nx = x + x_move[i]
        if 0 <= nx < x_size and 0 <= ny < y_size and graph[ny][nx] == -1:
            dfs(ny,nx)
            

y_size, x_size = map(int, input().split())

graph = [list(map(int, input().split())) for _ in range(y_size)]

# 방문 리스트 없이 첫번째 섬을 1로 표현하기위해 기존의 땅을 -1로 바꿔줍니다. 
for i in range(y_size):
    for j in range(x_size):
        if graph[i][j] == 1:
            graph[i][j] = -1


# 각 섬을 구분 해당 코드를 수행후에 cnt개의 섬으로 나눠 집니다. 
cnt = 0
for i in range(y_size):
    for j in range(x_size):
        if graph[i][j] == -1:
            cnt += 1
            dfs(i,j)
            
# ex) 
# [0, 0, 0, 0, 0, 0, 1, 1]
# [2, 2, 0, 0, 0, 0, 1, 1]
# [2, 2, 0, 0, 0, 0, 0, 0]
# [0, 0, 0, 0, 0, 3, 3, 0]
# [0, 0, 0, 0, 0, 0, 0, 0]
# [4, 4, 4, 4, 4, 4, 4, 4]
            
            
# 엣지 리스트 선언 힙큐 모듈을 사용    
edges = []
          
for i in range(y_size):
    for j in range(x_size):
        # 바다가 아닐 경우 
        if graph[i][j] != 0:
            
            # 상하좌우 방향으로 쭉 이동 
            for mx,my in zip(x_move, y_move):
                tmp_y, tmp_x = i, j
                l = 0
                while True:
                    # 더 이상 이동할 수 없을 경우 break
                    if not (0 <= tmp_x+mx < x_size and 0 <= tmp_y+my < y_size) or graph[tmp_y+my][tmp_x+mx] != 0:
                         break
                    tmp_y += my
                    tmp_x += mx
                    l += 1
                    
                tmp_x += mx
                tmp_y += my     
                
                # 멈춘 좌표가 x_size, y_size이내에 있으며 시작했던 섬과 다른 섬이라면 엣지리스트에 
                # 길이, 시작위치, 도착위치 순으로 넣어줍니다. 
                if 0 <= tmp_x < x_size and 0 <= tmp_y  < y_size and  l >= 2 and graph[tmp_y][tmp_x] != graph[i][j]:
                    heappush(edges, [l, graph[i][j], graph[tmp_y][tmp_x]])
        

# 유니온 파인트를 위한 리스트 선언 
check_set = [i for i in range(cnt+1)]

answer = 0
# cnt가 노드의 개수이므로 노드 -1 번 선을 연결하면 mst완성 
for i in range(cnt - 1):    
    while True:
        # 만약 섬을 모두 연결할 수 없다면 -1 출력 후 프로그램 종료
        if not edges:
            print(-1)
            exit()
        
        l,a,b = heappop(edges)
        
        # 두 노드가 다르다면 
        if find(a) != find(b):
            break
    # 유니온 연산 후 정답 += 연결 다리의 길이 
    union(a,b)
    answer += l
        

print(answer)               
      
                     