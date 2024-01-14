# 작성자: 황성민
# 작성날짜 : 2024.01.14
# 문제 접근 및 해결 : https://blog.naver.com/steadydeveloper/223321971630




# DFS 탐색
def dfs(node):
    global answer
    
    #들어온 노드는 방문 처리 
    visited[node] = True
    
    # 연결된 노드가 없다면 리프노드이므로 정답 += 1
    if not graph[node]:
        answer += 1
        
    # 현재 노드와 연결된 노드들 재귀적으로 탐색 
    for v in graph[node]:
        dfs(v)


# 노드개수 
N = int(input())

# 방문 체크 리스트 
visited= [False] * N

# 노드들의 관계를 리스트에 담아둠 
arr = list(map(int, input().split()))

# 금지 노드 
ban = int(input())

#그래프 표현 인접 리스트로 표현 
graph = [[] for _ in range(N)]
answer = 0

#부모 노드(시작 노드) 변수 선언 
start_node = 0

for i in range(N):
    # 만약 -1(연결된 부모가 없다면)이라면 
    if arr[i] == -1:
        # 시작 노드를 i번으로 
        start_node = i
        continue
    
    # 금지된(삭제된) 노드가 있다면 연결 X 
    if arr[i] == ban or i == ban:
        continue
    
    # 그래프 표현 (부모 노드 --> 자식 노드) 단방향 노드로  
    graph[arr[i]].append(i)
  
  
# 만약 시작 노드가 삭제된 노드라면 정답은 0
if start_node == ban:
    print(0)
else:
    #리프노드 개수 구하기 dfs로 실행 
    dfs(start_node)
    # 정답 출력
    print(answer)

