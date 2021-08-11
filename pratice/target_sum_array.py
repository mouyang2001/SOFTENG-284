def target_sum_brute_force(target, nums):
  for i in range(len(nums)):
    for j in range(i+1, len(nums)):
      if (nums[i]+nums[j] == target):
        print(nums[i], nums[j])
        return "found"
  return "none"

nums = [4,5,3,7,3]
target = 8
print(target_sum_brute_force(target, nums))

def target_sum_n_log_n(target, nums):
  # log n time
  nums = sorted(nums)
  i = 0
  j = len(nums)-1
  
  # linear n time
  while (i < j):
    if (nums[i] + nums[j] == target):
      print(nums[i], nums[j])
      return "found"
    if (nums[i] + nums[j] > target):
      j=j-1
    if (nums[i] + nums[j] < target):
      i=i+1
  return "none"

nums = [1,2,3,3,5,7,8]
target=6
print(target_sum_n_log_n(target, nums))

def twoSum(target, nums):
  nums_map = {}
  for i in range(len(nums)):
    c = target-nums[i]
    if (c in nums_map):
      return [i, nums_map.get(c)]
    else:
      nums_map[nums[i]] = i
  return "none"

nums = [2,7,11,15]
target = 9
print(twoSum(target, nums))
