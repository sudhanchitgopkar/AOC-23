f = open('in.txt')

sol = 0
id2qty = {}
for line in f:
    winning, ours = line.split('|')
    winning.strip()
    ours.strip()
    winning = winning.split()
    ours = ours.split()

    id = int(winning[1][:-1])
    if id not in id2qty:
        id2qty[id] = 1
    else:
        id2qty[id] += 1
    winning = winning[2:]


    score = 0
    for num in ours:
        if num in winning:
            score += 1
    
    for i in range(1, score + 1):
        if (id + i) not in id2qty:
            id2qty[id + i] = id2qty[id]
        else:
            id2qty[id + i] += id2qty[id]


print(sum([int(item) for item in id2qty.values()]))
