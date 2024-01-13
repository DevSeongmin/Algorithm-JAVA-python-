# https://www.acmicpc.net/problem/16120


stack = []
a = input()

for i in a:
    stack.append(i)
    while len(stack) >= 4 and stack [-4:] == ["P","P","A","P"]:
        stack.pop()
        stack.pop()
        stack.pop()
        
if len(stack) == 1 and stack[0] == "P":
    print('PPAP')
else:
    print("NP")