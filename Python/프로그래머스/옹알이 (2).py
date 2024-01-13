# 처음 풀이할 때 replace(p, '') 와 같이 공백으로 바꿔줬지만 다음과 같은 반례가 있다.
#  "yayae" -->  "ye"  --> ""
# 위의 반례를 해결하기 위해 "A"를 구분자로 주었고 
# 마지막에 대문자로만 이루어진 리스트의 요소 개수를 리턴하여 문제를 해결
# Lv1 치곤 어렵네...

def solution(babbling):
    
    possible = sorted(["aya", "ye", "woo", "ma"], key = len)[::-1]    
    impossible = list(map(lambda x: x * 2, possible))
    
    print(impossible)
    for idx, v in enumerate(babbling):
        
        for im in impossible:
            if im in v:
                break
        else:
            for p in possible:
                babbling[idx] = babbling[idx].replace(p, 'A')

    return sum(map(lambda x : x.isupper(), babbling))