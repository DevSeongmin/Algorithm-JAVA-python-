# 문제 핵심  슬라이딩 윈도우를 활용하여 

def solution(want, number, discount):
    
    d = dict(zip(want, number))
    answer = 0
    sum_number = sum(number)
    len_discount = len(discount)
    
    init_window = {}
    
    
    for i in range(sum_number):
        if discount[i] not in init_window:
            init_window[discount[i]] = 1
        else:
            init_window[discount[i]] += 1
              
    
    for i in range(len_discount - sum_number):
        
        if init_window == d:
            answer += 1
    
        init_window[discount[i]] -= 1
        if init_window[discount[i]] == 0:
            del init_window[discount[i]]
    
        if discount[i+sum_number] in init_window:
            init_window[discount[i+sum_number]] += 1
        else:
            init_window[discount[i+sum_number]] = 1
    
    if init_window == d:
        answer += 1

    return answer 




print(
    solution(["banana", "apple", "rice", "pork", "pot"],[3, 2, 2, 2, 1], ["chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"])
)

print(solution(["apple"], [10], ["banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"]))