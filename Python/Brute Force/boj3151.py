# https://www.acmicpc.net/problem/3151

# 하나의 기준 값을 잡고 투포인터를 활용해서 세 합이 0이 되도록한다.
# 핵심은 중복값이 있을 때를 처리하는 것!

import bisect

n = int(input())

students = sorted(tuple(map(int, input().split())))

cnt = 0 

for i in range(n-2):
    
    start = i+1
    end = n-1
    
    while start < end:
        
        if students[i] + students[start] + students[end] > 0:
            end -= 1
        
        elif students[i] + students[start] + students[end] < 0:
            start += 1
            
        else: # 세 합이 0일 경우 
            idx = bisect.bisect_left(students, students[end])
            cnt += end - max(idx-1, start)
            start += 1
            pass
print(cnt)