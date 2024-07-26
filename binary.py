import numpy as np
array = np.array([1, 3, 5, 7, 8, 9, 11, 13, 15, 17, 19])
target = int(input("Enter the number to be searched: "))
left = 0
right = len(array) - 1
index = -1
while left <= right:
    mid = (left + right) // 2
    if array[mid] == target:
        index = mid
        break
    elif array[mid] < target:
        left = mid + 1
    else:
        right = mid - 1
if index != -1:
    print(f"Element is found at index {index}")
else:
    print("Element not found in the array")
