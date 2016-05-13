#!/usr/bin/env python
# -*- coding: utf-8 -*-
def main():
    d = {}
    with open("inverse_index.dat") as f:
        for line in f:
            inputs = line.rstrip().split("\t")
            d[inputs[0]] = inputs[1:]

    while True:
        try:
            words = input().split()
        except (EOFError, KeyboardInterrupt) as e:
            return 0
        try:
            sets = [set(d[w]) for w in words]
        except KeyError as e:
            sets = [set()]

        for s in sets[1:]:
            sets[0] = sets[0].intersection(s)

        print(sorted(sets[0]) or "検索結果に一致する文書はありませんでした。")

if __name__ == "__main__":
    from sys import exit
    exit(main())

