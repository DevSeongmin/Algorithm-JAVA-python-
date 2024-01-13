# https://www.acmicpc.net/problem/2470


n = int(input())

arr = sorted(list(map(int, input().split())))


start = 0
end = n-1
answer = float('inf')

while start < end:
    
    if abs(arr[start] + arr[end]) < answer:
        answer = abs(arr[start] + arr[end])
        left, right = arr[start], arr[end]
        

    if arr[start] + arr[end] < 0:
        start += 1
        
    elif arr[start] + arr[end] > 0:
        end -= 1
    
    
    elif arr[start] + arr[end] == 0:
        left, right = arr[start], arr[end]
        break


print(left, right)