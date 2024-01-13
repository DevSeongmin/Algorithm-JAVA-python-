def solution(k, tangerine):
    
    del_num = len(tangerine) - k

    tangerine_dict = {}

    for t in tangerine:
        if t in tangerine_dict:
            tangerine_dict[t] += 1
        else:
            tangerine_dict[t] = 1
            
    tangerine_list = [(k,v) for k,v in tangerine_dict.items()]
    tangerine_list.sort(key = lambda x: -x[1])    
        

    while 1: 
        if del_num < tangerine_list[-1][1]:
            break
        else:
            del_num -= tangerine_list.pop()[1]

    return len(tangerine_list)


print(solution(2, [1, 1, 1, 1, 2, 2, 2, 3]))