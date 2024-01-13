# 분할 정복 문제 

# 처음에 모든 사각형의 1의 개수를 센다
# 모두 1일경우나 0일경우에 1의개수와 0의 개수 카운트 해주고 return 
# 아닐 경우 사각형을 4등분으로 쪼개고 다음과 같은 단계를 반복하여 
# 쿼드 트리의 0의 개수와 1의 개수를 구한다.

# 0 과 1의 개수를 구할 글로벌 변수 
zero = 0
one = 0

# 재귀 함수 구현 
def recursion(arr, start_x, end_x, start_y, end_y):
    global zero, one
    s = 0
    cnt = 0
    for y in range(start_y,end_y):
        for x in range(start_x,end_x):
            s += arr[y][x]
            cnt += 1
    
    if s == cnt:
        one += 1
        return
    elif s == 0:
        zero += 1
        return
    else:
        recursion(arr, start_x, (start_x + end_x)//2, start_y, (start_y + end_y)//2)
        recursion(arr, (start_x + end_x)//2, end_x, start_y, (start_y + end_y)//2)
        recursion(arr, start_x, (start_x + end_x)//2, (start_y + end_y)//2, end_y)
        recursion(arr, (start_x + end_x)//2, end_x, (start_y + end_y)//2, end_y)
        
    
   
def solution(arr):
    
    global one, zero
    
    l = len(arr)
    recursion(arr, 0, l, 0, l)
    
    return zero, one