def solution(N, stages):
    
    stages.sort(reverse = True)
    fail = list(map(lambda x : [x],range(N+1)))
    L = len(stages)
    
    for i in range(1, N+1):
        count = 0
        
        while stages and stages[-1] == i:
            stages.pop()
            count += 1
        if L != 0:
            fail[i].append(count/L)
            L -= count
        
        
    return [i[0] for i in sorted(fail[1:], key = lambda x: -x[1])]

solution(4,[2,2,2,2,2])