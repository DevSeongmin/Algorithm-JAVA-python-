# 투 포인터를 활용한 재밌는 문제 

def solution(gems):
    answer= []
    s_gems = set(gems)
    l = len(gems)
    s_l = len(set(gems))
    left = 0
    right = 0
    d = {gems[0]:1}
    
    
    # 투포인터의 이동 기준을 딕셔너리의 길이로 하여 최소한 모든 보석을 사는 인덱스를 구할 수 있다.
    while 1:
        if not len(d) == s_l:
            right += 1
            if right >= l:
                break
            d[gems[right]] = d.get(gems[right], 0) + 1
            
        else:
            answer.append([left+1, right+1])
            d[gems[left]] -= 1
            if d[gems[left]] == 0:
                del d[gems[left]]
            
            left += 1

    return sorted(answer, key = lambda x: x[1] - x[0])[0]
