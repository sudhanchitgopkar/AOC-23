sum = 0
f = open('in.txt')

for l in f:
    digits = [c for c in l if c.isdigit()]
    sum += int(digits[0] + digits[-1])

print(sum)
