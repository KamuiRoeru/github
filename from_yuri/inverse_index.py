#!/usr/bin/env python
# -*- coding: utf-8 -*-


from glob import glob
filenames = [f for f in glob("*.txt*")]
import re
basename_re = re.compile(".*\.txt")

from collections import defaultdict
d = defaultdict(set)

for filename in filenames:
    basename = basename_re.findall(filename)[0]

    with open(filename) as f:
        for line in f:
            d[line.split("\t")[0]].add(basename)

with open("inverse_index.dat", "w") as f:
    for k, v in sorted(d.items()):
        f.write(k + "\t" + "\t".join(sorted(v)) + "\n")

