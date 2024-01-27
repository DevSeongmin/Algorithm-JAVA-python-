

N, M = map(int, input().split())

visited = [False] * (N + 1)

arr = [0, 0]

def answer(depth, visit):
    if depth == M:
        print(*arr)
        return
    
    for i in range(1, N+1):
        
        if not visit[i]:
            arr[depth] = i
            visit[i] = True
            answer(depth+1, visit)    
            visit[i] = False
            arr[depth] = 0
        

answer(0,visited)