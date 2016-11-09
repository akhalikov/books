# coding=utf-8


def sort(numbers, is_reversed=False):
    for index in range(1, len(numbers)):
        curr_val = numbers[index]
        p = index - 1
        while p >= 0 and (numbers[p] <= curr_val if is_reversed else numbers[p] > curr_val):
            numbers[p + 1] = numbers[p]
            p -= 1
        numbers[p + 1] = curr_val
