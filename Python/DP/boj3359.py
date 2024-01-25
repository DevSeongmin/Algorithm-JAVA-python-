# 작성자 : 황성민
# 작성일자 : 24.01.26
# 문제 접근 및 풀이 : https://blog.naver.com/steadydeveloper/223333952084

n = int(input())

arr = [list(map(int, input().split())) for _ in range(n)]

dp = [[0,0] for _ in range(n)]


dp[0][0] = arr[0][1]
dp[0][1] = arr[0][0]

for i in range(1,n):
    dp[i][0] = max(abs(arr[i][0] - arr[i-1][0]) + arr[i][1] + dp[i-1][0],
                   abs(arr[i][0] - arr[i-1][1]) + arr[i][1] + dp[i-1][1])
    
    
    dp[i][1] = max(abs(arr[i][1] - arr[i-1][0]) + arr[i][0] + dp[i-1][0],
                   abs(arr[i][1] - arr[i-1][1]) + arr[i][0] + dp[i-1][1])
    
print(max(dp[-1]))