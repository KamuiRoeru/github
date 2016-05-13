#文字コード順でソートするプログラム
import sys,glob,MeCab,string
from os.path import basename

n = int(sys.argv[1])
sentence = ""
for source in glob.glob("./*.txt"):
    print(basename(source))
    with open(basename(source), encoding = "utf-8") as a_file:
        sentence += "".join([arg1.strip() for arg1 in a_file])

t = MeCab.Tagger("-F %f[6]\\n")
lists = []
for words in [word for word in t.parse(sentence).split("\n") if isinstance(word.type(None)) != None]:
    if (words == ""):
        continue
    elif (words == "EOS"):
        continue
    print(words)
    lists.append(words)

i = 0
gram_total = 0
from collections import defaultdict
dic = defaultdict(int)
lis_len = len(lists)
for i in range(lis_len - n + 1):
    gram_total += 1
    dic["-".join(lists[i:i+n])] += 1

with open("../output.txt", "w") as f:
    seikika = 0.0
    for i,j in sorted(dic.items(), key = lambda x:x[1], reverse=True):
        f.write("{:20}\t{}\t{}\n".format(i,j,j/gram_total))
        seikika = j /gram_total + seikika
    f.write("グラム総要素数=" + str(gram_total) + " 正規化値合計=" + str(seikika) + "\n")
