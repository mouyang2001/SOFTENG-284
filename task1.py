# Author: Matthew Ouyang
# Task: find the maximum profit from a list of stock prices
# Commands to execute code:
# > python3 task1.py < canvas.in > myout1.txt
# > diff myout1.txt canvas.out1

import sys
import re

# more efficient solution O(n)
def find_max_profit(prices, length):
  max_profit = prices[1] - prices[0]
  min_price = prices[0]
    
  for i in range(1,length):
    if (prices[i] - min_price > max_profit):
      max_profit = prices[i] - min_price
  
    if (prices[i] < min_price):
      min_price = prices[i]
  return max_profit

# driver code stdin/stdout
for line in sys.stdin:
  prices = list(map(int, re.findall('\d+', line)))
  length = prices.pop(0)
  if length >= 2:
    sys.stdout.write(str(find_max_profit(prices, length)) + '\n')

