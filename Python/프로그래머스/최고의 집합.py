# 수학적으로 몫과 나머지 연산을 잘 활용하여 풀 수 있는 문제 
# 풀이 방법 TC 3, 11 이라면 
# 몫과 나머지 연산으로 11 // 3 은 3 이므로 [3, 3, 3]의 리스트를 만들어줍니다.
# 이후 11 % 3 의 나머지 연산인 2를 리스트로 순서대로 돌면서 1씩 넣어줍니다. 
#  result  =  [4, 4, 3]
# return(sorted(result))

def solution(n, s):
    
    if n > s: return [-1]
    
    arr = [s//n] * n
    i = 0
    c = s % n
    
    while c > 0:
        arr[i] += 1
        c -=1
        i = (i+1) % n
        
    return sorted(arr)
    
    