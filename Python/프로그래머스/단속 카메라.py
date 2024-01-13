# 그리디 문제
# 차량이 지나가는 경로를 나타내는 routes를 정렬

from collections import deque

def solution(routes):
    answer = 0
    routes = deque(sorted(routes))
    cnt = 0
    
    while routes:
        
        # 초기 상태거나 현재 차의 끝나는 지점보다 다음 차의 시작 지점이 더 뒤에 있어서
        #카메라 개수를 하나 늘려준다.
        cnt += 1
        tmp = routes.popleft()[1]
        
        # 앞 차의 경로의 끝나는 지점보다 다음 차의 시작점이 더 앞이라면 
        # 다음차의 끝나는 지점을 비교 대상으로 잡는다. 
        while routes and tmp >= routes[0][0]:
            tmp = min(tmp, routes.popleft()[1])
            
    return cnt