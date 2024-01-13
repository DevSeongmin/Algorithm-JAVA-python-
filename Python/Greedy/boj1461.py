# https://www.acmicpc.net/problem/1461


number_of_book, capacity = map(int, input().split())

books = sorted(list(map(int, input().split())))

positive = [0]
negative = [0]

for book in books:
    if book > 0: positive.append(book)
    else: negative.append(-book)
    
max_val = max(max(positive),max(negative))
    
del positive[0]
del negative[0]
negative = negative[::-1]

solve = 0




while negative:
    tmp = negative.pop()
    solve += tmp * 2
    for i in range(capacity-1):
        if negative:
            negative.pop()
            
while positive:
    tmp = positive.pop()
    solve += tmp * 2
    for i in range(capacity - 1):
        if positive:
            positive.pop()
            
            
print(solve - max_val)