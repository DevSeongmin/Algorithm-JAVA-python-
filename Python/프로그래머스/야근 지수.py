# 시간 복잡도를 최대한 줄이고자 계수 정렬(공간으로 시간벌기)을 활용해서 풀었지만
# 단순하게 풀어도 통과가 되는 문제...
def solution(n, works):
    
    l = max(works)
    arr = [0] * (l+1)
    
    for w in works:
        arr[w] += 1
    
    for i in range(l ,0, -1):
        if arr[i] < n:
            n -= arr[i]
            arr[i-1] += arr[i]
            arr[i] = 0
            
        elif arr[i] > n:
            arr[i] -= n
            arr[i-1] += n
            break
            
        else:
            arr[i-1] += arr[i]
            arr[i] = 0
            break
            
            
    answer = 0
    
    for idx, value in enumerate(arr):
        answer += idx ** 2 * value
            
    return answer