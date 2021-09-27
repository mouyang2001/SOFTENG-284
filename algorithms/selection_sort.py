a = [1,5,2,8,2,4,1,8,2,4,8,3,6]

# Selection sort algorithm
# Best case: O(n^2)
# Worst case: O(n^2)
# Average case: O(n^2)
# In-place and stable.
def selection_sort(a):
    for i in range(len(a)):
        min_index = i
        for j in range(i+1, len(a)):
            if a[j] < a[min_index]:
                min_index = j
        # python3 swapping
        a[i], a[min_index] = a[min_index], a[i]
    return a

# classic swap method, but no in-place
def swap(a, i, j):
    temp = a[i]
    a[i] = a[j]
    a[j] = temp

# run
print(selection_sort(a))