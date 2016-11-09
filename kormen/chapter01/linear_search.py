# coding=utf-8


def search(numbers, key):
    for index in range(0, len(numbers)):
        curr_val = numbers[index]
        if curr_val == key:
            return index
    return None
