import sys
from itertools import combinations

input = sys.stdin.readline
l, c = map(int, input().split())
arr = sorted(input().split())

vowel = ['a','e','i','o','u']
for comb in combinations(arr, l):
    vowel_count = 0
    consonants_count = 0
    for tmp in comb:
        if tmp in vowel:
            vowel_count += 1
        else:
            consonants_count += 1
    if vowel_count >= 1 and consonants_count >= 2:
        print("".join(comb))
    