# 구현 문제

def solution(n):
    snail = [[0] * i for i in range(1,n+1)]
    k = (n + 1) * n // 2
    cnt = 1
    #   아래쪽 이동, 오른쪽 이동, 왼쪽 대각선 이동 좌표 리스트
    move = [(0,1), (1,0), (-1,-1)]
    current = 0
    
    x,y = 0,0
    
    while 1:
        snail[y][x] = cnt       
        if cnt >= k:
            break
        
        #  0 <= 이동했을 때 범위 < n 이고   이동 했을 때 인덱스 값이 0이라면 이동  
        if 0 <= x + move[current][0] < n and 0 <= y + move[current][1] < n and snail[y + move[current][1]][x + move[current][0]] == 0:
            cnt += 1
            y += move[current][1]
            x += move[current][0]
        else:
            current = (current + 1) % 3
        
        
        # 차원 축소 후 정답 리턴 
    return [i for s in snail for i in s]
 # + 신기한 파이썬 기능 
 #  sum(snail, []) 로 차원을 축소시킬 수 있다.
 # ex [[1],[2,3], [4,5,6]] 이라면 
 #  [] + [1] + [2, 3] + [4, 5, 6] 으로 작동해서 구하고자 하는 답이 나온다
 # 하지만 실행 시간이 좀 느림
 
 #리스트 컴프리헨션 VS SUM(list, [])
 
 
import time

# 큰 데이터셋 생성
original_list = [[1] * 1000] * 1000

# 리스트 컴프리헨션을 사용한 방법의 실행 시간 측정
start_time = time.time()
flattened_list = [element for sublist in original_list for element in sublist]
end_time = time.time()
print("List Comprehension Execution Time:", end_time - start_time)

# sum 함수를 사용한 방법의 실행 시간 측정
start_time = time.time()
flattened_list = sum(original_list, [])
end_time = time.time()
print("sum() Function Execution Time:", end_time - start_time)
