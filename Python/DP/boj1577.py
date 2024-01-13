y, x = map(int, input().split())
ban = int(input())

bans = []
for _ in range(ban):
    a,b,c,d = map(int, input().split())
    # 좌표를 정렬하여 벤 리스트에 넣어줍니다. 오른쪽 혹은 아래 있는 좌표가 뒤쪽에 오도록 
    bans.append(sorted([[a,b], [c,d]]))


dp = [[0] * (x + 1) for _ in range(y+1)]

# 시작점을 1로 
dp[0][0] = 1

# 첫 행과 첫 열에 대해 막는 도로가 없다면 1로 초기화 해줍니다.
for i in range(1, x+1):    
    if [[0,i-1], [0,i]] in bans:
        continue
    dp[0][i] = dp[0][i-1]
for i in range(1, y+1):
    if [[i-1,0], [i,0]] in bans:
        continue
    dp[i][0] = dp[i-1][0]
    



for i in range(1, y+1):
    for j in range(1, x+1):
        
        # 점화식 수행 
        # 만약 이전 지점에서 현재 지점으로의 막는 도로가 있다면 막는 도로의 시작점은 더해 주지 않습니다. 
        if [[i-1,j], [i,j]] in bans and [[i,j-1], [i,j]] in bans:
            continue
        elif [[i-1,j], [i,j]] in bans:
            dp[i][j] = dp[i][j-1]
        
        elif [[i,j-1], [i,j]] in bans:
            dp[i][j] = dp[i-1][j]
        
        else:    
            dp[i][j] = dp[i-1][j] + dp[i][j-1]
        
# 목적지의 값 출력 
print(dp[-1][-1])  
        
        