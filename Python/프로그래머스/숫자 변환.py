# Queue 자료구조를 이용하여 풀이 
# 실행 시간을 단축하기 위해 
# x -> y 가 아닌
# y -> x 로 접근
from collections import deque

def solution(x, y, n):
    
    new_que = deque([y])
    cnt = 0
    
    while new_que:
        
        my_que = deque(new_que)
        new_que = deque()
        if x in my_que:
            return cnt
        
        while my_que:
        
            tmp = my_que.popleft()
            
            if tmp % 3 == 0 and tmp // 3 >= x:
                new_que.append(tmp // 3)

            if tmp % 2 == 0 and tmp // 2 >= x:
                new_que.append(tmp // 2)

            if tmp - n >= x:
                new_que.append(tmp-n)
        
        cnt += 1
    return -1