size_a, size_b = map(int,input().split())

list_a = list(map(int, input().split()))
list_b = list(map(int, input().split()))

answer=[]

pointer_a = 0
pointer_b = 0
max = 0

while pointer_a < size_a or pointer_b < size_b:
  if pointer_b >= size_b or (pointer_a < size_a and list_a[pointer_a] <= list_b[pointer_b]):
    answer.append(list_a[pointer_a])
    pointer_a += 1
  else:
    answer.append(list_b[pointer_b])
    pointer_b += 1

print(*answer)