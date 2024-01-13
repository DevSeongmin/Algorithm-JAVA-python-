import re

def solution(str1, str2):
    
    str1 = str1.upper()
    str2 = str2.upper()
    
    str1_dict = {}
    str2_dict = {}
    
    for i in range(1, len(str1)):
        if str1[i-1] + str1[i] == re.sub(r"[^a-zA-Z]", "", str1[i-1] + str1[i]):
            if str1[i-1] + str1[i] not in str1_dict:
                str1_dict[str1[i-1] + str1[i]] = 1
            else:
                str1_dict[str1[i-1]+str1[i]] += 1
    
    for i in range(1, len(str2)):
        if str2[i-1] + str2[i] == re.sub(r"[^a-zA-Z]", "", str2[i-1] + str2[i]):
        
            if str2[i-1] + str2[i] not in str2_dict:
                str2_dict[str2[i-1] + str2[i]] = 1
            else:
                str2_dict[str2[i-1]+str2[i]] += 1
    
    sum_dict = {}
    
    for k, v in str1_dict.items():
        if k not in sum_dict or sum_dict[k] < v:
            sum_dict[k] = v
    
    for k, v in str2_dict.items():
        if k not in sum_dict or sum_dict[k] < v:
            sum_dict[k] = v
            
            
    inter_dict = {}
    for k, v in str1_dict.items():
        if k in str2_dict:
            inter_dict[k] = min(v, str2_dict[k])
    
    if not str1_dict and not str2_dict: 
        return 65536
        
    return int(sum(inter_dict.values()) / sum(sum_dict.values()) * 65536)
    