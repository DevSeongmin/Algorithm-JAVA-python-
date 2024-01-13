def solution(s):
    answer = []
    s = eval(s.replace('{', '[').replace('}', ']'))
    s.sort(key = len)
    
    for arr in s:
        for arg in arr:
            if arg not in answer:
                answer.append(arg)
                
    return answer
