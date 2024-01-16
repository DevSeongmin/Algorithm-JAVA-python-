# 
# 작성자 : 황성민
# 작성일자 : 24.01.16
# 알고리즘 부류 : 투 포인터
# 문제 해결 : https://blog.naver.com/steadydeveloper/223324638575
# 

N = int(input())

arr = list(map(int, input().split()))

left, right = 0, N-1
answer  = [0,0]

check_value = float("INF")
current_value = arr[0] + arr[right]

while left < right:
    if abs(current_value) < check_value:
        check_value = abs(current_value)
        answer[0],answer[1] = arr[left], arr[right]
        
    if current_value < 0:
        current_value -= arr[left]
        left+=1
        current_value += arr[left]
        
    else:
        current_value -= arr[right]
        right-=1
        current_value += arr[right]
        
print(*answer)