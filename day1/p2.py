sum = 0
f = open('tst.txt')
l2n = {}

l2n['one'] = 1
l2n['two'] = 2
l2n['three'] = 3
l2n['four'] = 4
l2n['five'] = 5
l2n['six'] = 6
l2n['seven'] = 7
l2n['eight'] = 8
l2n['nine'] = 9


for l in f:
    first = -1
    firsti = 10000
    last = -1
    lasti = -1

    for num in l2n:
        if l.find(num) != -1 and l.find(num) < firsti:
            first = l2n[num]
            firsti = l.find(num)
        
        if l.rfind(num) != -1 and l.rfind(num) < lasti:
            last = l2n[num]
            lasti = l.find(num)

    for i,c in enumerate(l):
        if i > firsti:
            break
        elif c.isdigit():
            first = int(c)
            break

    for i,c in reversed(list(enumerate(l))):
        if i < lasti:
            break
        elif c.isdigit():
            last = int(c)
            break
        
    print(first * 10 + last)
    sum += (first * 10 + last)

print(sum)
