import numpy as np
n = int(input("Enter the number of elements in the array: "))
elements = []
for i in range(n):
    element = int(input("Enter element {}: ".format(i + 1)))
    elements.append(element)
array = np.array(elements)
sorted_array = np.sort(array)
sorted_array_desc = sorted_array[::-1]
print("Original array:", array)
print("Array in ascending order:", sorted_array)
print("Array in descending order:", sorted_array_desc)
