# coding=utf8

from nose.tools import *
from chapter01 import insertion_sort, linear_search


def test_insertion_sort():
    numbers = [5, 2, 4, 6, 1, 3, 4]

    expected = sorted(numbers)
    insertion_sort.sort(numbers)
    assert numbers == expected


def test_insertion_sort_reversed():
    numbers = [5, 2, 4, 6, 1, 3, 4]

    expected = sorted(numbers, reverse=True)
    insertion_sort.sort(numbers, is_reversed=True)
    assert numbers == expected


def test_linear_search():
    numbers = [5, 2, 4, 6, 1, 3, 4]
    n = len(numbers)

    assert 0 == linear_search.search(numbers, 5)
    assert 2 == linear_search.search(numbers, 4)
    assert 4 == linear_search.search(numbers, 1)
