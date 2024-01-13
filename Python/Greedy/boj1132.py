N = int(input())

alpha_val = {}


string_arr = []

for i in range(N):
    string_arr.append(input())


for string in string_arr:
    
    tmp_l = len(string)
    radix = 10 ** (tmp_l - 1)
    for j in string:
        
        if not j in alpha_val:
            alpha_val[j] = radix
        else:
            alpha_val[j] += radix
        radix //= 10
            
sorted_data = sorted(alpha_val.items(), key=lambda x: -x[1])

new_data = {}
value = 9
for key, _ in sorted_data:
    new_data[key] = str(value)
    value -= 1


answers = [''.join([new_data[s] for s in item]) for item in string_arr]
print(sum(map(int,answers)))
print(alpha_val)
print(answers)