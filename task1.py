# command to run
# python3 task1.py < sample_input > task1_output.txt
# diff task1_output.txt sample_output

import sys
import re

# more efficient solution O(n)
def find_max_profit(arr, arr_size):
  max_profit = arr[1] - arr[0]
  min_price = arr[0]
    
  for i in range( 1, arr_size ):
      if (arr[i] - min_price > max_profit):
          max_profit = arr[i] - min_price
    
      if (arr[i] < min_price):
          min_price = arr[i]
  return max_profit

# driver code stdin/stdout
for line in sys.stdin:
  prices = list(map(int, re.findall('\d+', line)))
  length = prices.pop(0)
  if length >= 2:
    sys.stdout.write(str(find_max_profit(prices, length)) + '\n')

