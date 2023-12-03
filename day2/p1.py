f = open('in.txt')

sum = 0
for line in f:
    r = 0
    g = 0
    b = 0
    valid = True

    line += ';'
    pulls = line.split(';')
    words = line.split()

    for pull in pulls:
        nums = pull.split()
        
        for i, num in enumerate(nums):
            if num.find('red') != -1:
                r = int(nums[i - 1])
            if num.find('green') != -1:
                g = int(nums[i - 1])
            if num.find('blue') != -1:
                b = int(nums[i - 1])
        
        if r > 12 or g > 13 or b > 14:
            valid = False
            
    if valid:    
        sum += int(words[1][0:-1])

print(sum)
