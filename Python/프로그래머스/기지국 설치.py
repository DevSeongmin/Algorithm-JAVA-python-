# 해당 문제는 수학적으로  기지국이 닿지 않는 연속된 아파트의 개수를 구하고 
# 그 개수를 w*2+1 로 나눈수를 올림하여 풀 수 있다. 복잡도를 최소화 하여 풀 수 있다.

import math

def solution(n, stations, w):
    # 16, [9], 2   의 테스트 케이스라면 
    # 마지막에 n + w + 1을 추가 
    #[19]이 되는데 이렇게 하면 원래의 9부터 16까지의 빈 아파트도 아래의 루프를 실행하며 깔끔하게 구할 수 있다 
    stations.append(n + w+1)
    answer = 0
    
    i = 1
    for station in stations:
        answer += math.ceil((station - w - i) / (w*2+1))
        i = station + w + 1
        
    return answer