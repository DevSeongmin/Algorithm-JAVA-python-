
# 
#  작성자 : 황성민
#  작성일자 24.01.17
#  문제 해결 및 풀이 : https://blog.naver.com/steadydeveloper/223325711700
#  

import sys

input = sys.stdin.readline

N, W = map(int, input().split())

items = [[0,0]] +  [list(map(int, input().split())) for _ in range(N)]
DP =  [[0] * (W + 1) for _ in range(N+1)]


for item in range(1,N+1):
    for weight in range(1,W+1):
        
        w = items[item][0]
        v = items[item][1]
        
        if items[item][0] <= weight:
            DP[item][weight] = max(DP[item-1][weight], DP[item-1][weight-w] + v)
            
        else:
            DP[item][weight] = DP[item-1][weight]
        
        
        
print(DP[-1][-1])