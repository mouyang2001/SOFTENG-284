# usage: generator m n 
# where m is the number of sequences and
# n is the length of the sequence

import sys
import random
number_of_cases = int(sys.argv[1])
n = int(sys.argv[2])

for i in range(number_of_cases):
    print(n, end=' ')
    for j in range(n):
        print(random.randint(1,100000), end=' ')
    print()

print(0)

