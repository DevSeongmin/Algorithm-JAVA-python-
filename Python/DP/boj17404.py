# 작성자 : 황성민
# 작성일자 24.01.20
# 문제 해결 및 풀이 : https://blog.naver.com/steadydeveloper/223328405098

from copy import deepcopy

def solution(start, dp):
    dp[0][(start+1)%3] = INF
    dp[0][(start+2)%3] = INF
    dp[N-1][start] = INF
    
    for i in range(1,N):
        for j in range(3):
            minVal = INF
            for k in range(3):
                if j != k:
                    minVal = min(minVal,dp[i-1][k])
            
            dp[i][j]+= minVal
            
            
    return min(dp[-1])



N = int(input())

arr = [list(map(int, input().split())) for _ in range(N)]

INF = float('inf')

answer = INF

for start in range(3):
    answer = min(answer, solution(start,deepcopy(arr)))
    
print(answer)
