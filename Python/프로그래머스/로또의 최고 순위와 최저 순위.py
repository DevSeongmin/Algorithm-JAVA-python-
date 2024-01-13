# 그냥 수학, 구현 문제
# 왜 정답률이 낮은지는... 

def solution(lottos, win_nums):
    
    d = dict(zip(range(6,0,-1), range(1,7)))
    d[0] = 6
    c = 0
    for i in lottos:
        if i in win_nums:
            c += 1
    
    return [d[c + lottos.count(0)], d[c]]