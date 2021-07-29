# command to run
# python3 task1.py < sample_input > task1_output.txt
# diff task1_output.txt sample_output

import sys
import re

# inefficient solution O(n^2)
def find_max_profit(prices, length):
  max_profit = 0
  for i in range(length):
    for j in range(i+1, length):
      profit = prices[j] - prices[i]
      if profit > max_profit:
        max_profit = profit
  return max_profit

# driver code stdin/stdout
for line in sys.stdin:
  prices = list(map(int, re.findall('\d+', line)))
  length = prices.pop(0)
  if length >= 2:
    sys.stdout.write(str(find_max_profit(prices, length)) + '\n')
