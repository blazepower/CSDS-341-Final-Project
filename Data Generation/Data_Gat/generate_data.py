#!~/bin/usr/python3
import random
import json

def read_first_names():
    ret = []
    for line in open("raw_F_names.txt"):
        ret.append(line.replace("\n", ""))
    print(ret)
    return ret

def make_pretty(st):
    tmp = st.lower()
    return tmp.capitalize()

def read_last_names():
    ret = []
    for line in open("raw_L_names.txt"):
        tmp = line.split(" ")
        ret.append(make_pretty(tmp[1]))
    print(ret)
    return ret

#Load NFL data
FIRST_NAMES = read_first_names()
LAST_NAMES = read_last_names()
DATA = [
        ["Arizona"," Cardinals"],
        ["Atlanta", "Falcons"],
        ["Baltimore", "Ravens"],
        ["Buffalo", "Bills"],
        ["Carolina", "Panthers"],
        ["Chicago", "Bears"],
        ["Cincinnati", "Bengals"],
        ["Cleveland", "Browns"],
        ["Dallas", "Cowboys"],
        ["Denver", "Broncos"],
        ["Detroit", "Lions"],
        ["Green Bay", "Packers"],
        ["Houston", "Texans"],
        ["Indianapolis", "Colts"],
        ["Jacksonville", "Jaguars"],
        ["Kansas City", "Chiefs"],
        ["Las Vegas", "Raiders"],
        ["Los Angeles", "Chargers"],
        ["Los Angeles", "Rams"],
        ["Miami", "Dolphins"],
        ["Minnesota", "Vikings"],
        ["New England", "Patriots"],
        ["New Orleans", "Saints"],
        ["New York", "Giants"],
        ["New York", "Jets"],
        ["Philadelphia", "Eagles"],
        ["Pittsburgh", "Steelers"],
        ["San Francisco", "49ers"],
        ["Seattle", "Seahawks"],
        ["Tampa Bay", "Buccaneers"],
        ["Tennessee", "Titans"],
        ["Washington", "Redskins"]
        ]

def rand_int(l, u):
    return random.randint(l, u)

def rand_name():
    first = FIRST_NAMES[rand_int(0, len(FIRST_NAMES)-1)]
    last = LAST_NAMES[rand_int(0, len(LAST_NAMES)-1)]
    return first + " " + last

def make_defence():
    ret = {}
    ret["Interceptions"] = rand_int(0, 25)
    ret["Sacks"] = rand_int(0, 25)
    ret["rshYdsAllowed"] = rand_int(1000, 2000)
    ret["passYdsAllowed"] = rand_int(3000, 4000)
    return ret

def make_WR():
    ret = []
    for i in range(7):
        tmp = {}
        tmp["name"] = rand_name()
        tmp["recYards"] = rand_int(0, 1500)
        tmp["catches"] = rand_int(0, 150)
        tmp["tds"] = rand_int(0, 20)
        tmp["fumbles"] = rand_int(0, 20)
        tmp["drops"] = rand_int(0, 50)
        ret.append(tmp)
    return ret

def make_RB():
    ret = []
    for i in range(3):
        tmp = {}
        tmp["name"] = rand_name()
        tmp["recYds"] = rand_int(0, 750)
        tmp["rshYds"] = rand_int(0, 1500)
        tmp["catches"] = rand_int(0, 50)
        tmp["tds"] = rand_int(0, 50)
        tmp["fumbles"] = rand_int(0, 25)
        tmp["drops"] = rand_int(0, 25)
        ret.append(tmp)
    return ret

def make_QB():
    ret = []
    for i in range(3):
        tmp = {}
        tmp["name"] = rand_name()
        tmp["passingYards"] = rand_int(1000, 4000)
        tmp["rushingYards"] = rand_int(0, 500)
        tmp["completions"] = rand_int(0, 450)
        tmp["tds"] = rand_int(0, 40)
        ret.append(tmp)
    return ret
def make_K():
    ret = []
    for i in range(1):
        tmp = {}
        tmp["name"] = rand_name()
        tmp["fgMade"] = rand_int(0, 50)
        tmp["fgMissed"] = rand_int(0, 50)
        ret.append(tmp)
    return ret


d = []
i = 0
a = 0
n = 0
for entry in DATA:
    tmp = {}
    tmp["teamName"] = entry[1]
    tmp["location"] = entry[0]
    tmp["stadium"] = entry[0] + " " + entry[1] + " Stadium"
    tmp["superbowls"] = rand_int(0, 10)
    tmp["stadiumCapacity"] = rand_int(50, 100) * 1000
    tmp["headCoach"] = rand_name()
    tmp["manager"] = rand_name()
    tmp["owner"] = rand_name()
    tmp["record"] = str(rand_int(-10, 10))
    tmp["defence"] = make_defence()
    tmp["wideReceiver"] = make_WR()
    tmp["RunningBack"] = make_RB()
    tmp["QuarterBack"] = make_QB()
    tmp["Kicker"] = make_K()
    if i < 16:
        tmp["Division"] = "AFC"
        a += 1
    else:
        tmp["Division"] = "NFC"
        n += 1
    i += 1
    d.append(tmp)

def print_pretty(d, indent=0):
    for key, value in d.items():
        print('\t' * indent + str(key))
        if isinstance(value, dict):
            print_pretty(value, indent+1)
        else:
            print('\t' * (indent+1) + str(value))


for item in d:
    print_pretty(item)

with open("data.json", 'w') as fout:
    json.dump(d, fout)
