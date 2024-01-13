# 단순 구현 문제 

def solution(record):
    
    answer = []
    d = {}
    record = list(map(lambda x: x.split(), record))
    
    for r in record:    
        if r[0] == "Enter":
            d[r[1]] = r[2]
            answer.append((r[1], "님이 들어왔습니다."))
        
        if r[0] == "Change":
            d[r[1]] = r[2]
        
        if r[0] == "Leave":
            answer.append((r[1], "님이 나갔습니다."))
    
    
    return list(map(lambda x: d[x[0]] + x[1], answer))