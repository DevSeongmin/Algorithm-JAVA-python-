# 구현 문제
# dict.get(Key, Default_value) <---  딕셔너리 메서드를 알면 쉽게 구현할 수 있는 문제

import math

def solution(fees, records):
    
    records = list(map(lambda x:x.split(), records))
    time_d = {}
    answer_d = {}
    for time, car_num, move in records:
        
        if move == "IN":
            time_d[car_num] = (int(time[:2]), int(time[3:]))
            
        else:
            tmp = time_d.pop(car_num)
            answer_d[car_num] = answer_d.get(car_num, 0) + (int(time[:2]) - tmp[0]) * 60 + (int(time[3:]) - tmp[1])
            
    for car_num in time_d:
        answer_d[car_num] = answer_d.get(car_num, 0) + (23 - time_d[car_num][0]) * 60 + 59 - time_d[car_num][1]
    
    answer = []
    
    for _, v in sorted(answer_d.items()):
        if v <= fees[0]:
            answer.append(fees[1])
        else:
            answer.append(fees[1] + math.ceil((v - fees[0]) / fees[2]) * fees[3])
            
    return answer