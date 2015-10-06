// Sets
// duplicates will be removed:
val s = Set(1, 1, 2, 3, 9, 9, 4, 22, 11, 7, 6)
s(1)
s(29)
// type mismatch
//s("Hello")

// Sets are unordered
Set(7, 11, 2, 3).subsetOf(s)

// Union:
s.union(Set(2, 3, 4, 99))
s union Set(2, 3, 4, 99)
s | Set(2, 3, 4, 99)

// Intersection:
s & Set(0,1,11,22,87)
s intersect Set(0,1,11,22,87)

// Difference:
s -- Set(0, 1, 11, 22, 87)
s &~ Set(0, 1, 11, 22, 87)