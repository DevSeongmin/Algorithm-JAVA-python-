#https://www.acmicpc.net/problem/1946


#문제 이해가 힘듬... 
#난독증인가?
import sys
input = sys.stdin.readline

for _ in range(int(input())):
    arr = []
    n = int(input())

    arr = sorted([list(map(int, input().split())) for _ in range(n)])
    
    count = 1
    min_val = arr[0][1]
    for i in range(1,n):
        if arr[i][1] < min_val:
            count += 1
            min_val = arr[i][1]
            
    print(count)