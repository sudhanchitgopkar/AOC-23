f = open('in.txt')

sol = 0

for line in f:
    winning, ours = line.split('|')
    winning.strip()
    ours.strip()
    winning = winning.split()
    ours = ours.split()
    winning = winning[2:]

    #print(winning)
    #print(ours)
    
    score = 0
    for num in ours:
        if num in winning:
            if score == 0:
                score += 1
            else:
                score *= 2
    sol += score

print(sol)
