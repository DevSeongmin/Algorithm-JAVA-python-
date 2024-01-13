# 전형적인 DP 문제 
# 배열로 케이스가 주어지지만 문제를 읽어보면 원형으로 된 스티커를 뜯어 최댓값을 도출하는 문제이다. 
# Ex) [100, 3, 4, 5, 105] 

# 0 번째 인덱스에서 L -1 번째 까지 

# maximum = max(maximum, dp[-2])
#dp.append(max(dp[-1],  maximum + sticker[i])) 이 점화식으로 마지막 값을 구하게 되면 
# 처음 스티커를 뜯고 마지막 스티커를 안뜯는 경우로 생각할 수 있다.

# 즉 0 ~ L-1 의 DP와 
#1, L 까지의 DP의 최댓값을 구해 문제를 해결

def solution(sticker):
    answer = 0
    dp = sticker[:2]
    maximum = 0
    
    for i in range(2, len(sticker) - 1):
        maximum = max(maximum, dp[-2])
        dp.append(max(dp[-1],  maximum + sticker[i]))
        
    answer = max(answer, dp[-1])
    sticker = sticker[::-1]
    dp = sticker[:2]
    maximum = 0
    
    for i in range(2, len(sticker) - 1):
        maximum = max(maximum, dp[-2])
        dp.append(max(dp[-1],  maximum + sticker[i]))
        
    answer = max(answer, dp[-1])

    return answer