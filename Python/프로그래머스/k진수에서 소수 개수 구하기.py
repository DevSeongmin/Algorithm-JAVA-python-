def prime(n):
    
    if n == 1:
        return False
    
    for i in range(2, int(n**0.5) + 1):
        if n % i == 0:
            return False
    return True


def k_trans(n,k):
    
    s = ''
    
    while n != 0:
        s += str(n % k)
        n //= k
    return s[::-1]
    
    
def solution(n, k):
    c = 0
    print(k_trans(n,k).split('0'))
    
    for i in k_trans(n,k).split('0'):
        if i.isdigit() and prime(int(i)):
            c += 1
    return c
