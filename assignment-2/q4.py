# Author: Matthew Ouyang
# Task: find the number of wire intersection points
# Commands to execute code:
# > python3 q4.py < canvas.in > myout.txt
# > diff myout.txt canvas.out

import sys
from ast import literal_eval

def find_crosses(height, wires):
    crosses = 0

    # create a hash map to look up wire
    wires_map = {}
    for wire in wires:
        wires_map[wire[0]] = wire[1]

    i_sort = sorted([x[0] for x in wires])
    j_sort = sorted([x[1] for x in wires])

    # bottom up approach
    n = len(i_sort)
    for x in range(n):
        jp = wires_map.get(i_sort[x])
        for y in range(x+1, n):
            if wires_map.get(i_sort[y]) < jp:
                crosses = crosses + 1
    
    return crosses

# driver code stdin/stdout
first_read = False
scenarios = 0
for line in sys.stdin:
    # ignore first line
    if first_read == False:
        first_read = True
        scenarios = int(line)
        continue
    
    # split the line by tower height and wire tuple
    height, wires = line.split()
    wires = literal_eval(wires)
    
    # write to stdout
    sys.stdout.write(str(find_crosses(height, wires)) + "\n")
