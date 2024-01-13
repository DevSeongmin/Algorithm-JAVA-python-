# 이거 왜 3단계...

def solution(A, B):
    A.sort(reverse = True)
    B.sort(reverse = True)
    cnt = 0 
    
    while B:
        tmp = B.pop()
        if A[-1] < tmp:
            A.pop()
            cnt += 1
    
    return cnt 