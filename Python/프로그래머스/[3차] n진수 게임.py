# 진법 변환의 개념을 알고 있다면 쉽게 풀 수 있는 문제

def trans(n, number):
    arr = ['0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F']
    answer = ''
    if number < 2:
        return str(number)
    
    while number >= 1:
        answer += arr[number % n]
        number //= n

    return answer[::-1] 


def solution(n, t, m, p):
    answer = ''
    i = 0
    while len(answer) < t * m :
        answer += trans(n,i)
        i += 1
    
    return answer[p-1::m][:t]