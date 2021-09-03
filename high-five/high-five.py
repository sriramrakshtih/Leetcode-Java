

class Solution:
    def highFive(self, items: List[List[int]]) -> List[List[int]]:
        
        ids = []
        sums = []
        checked = []

        # sort the list with second digit descending for each id

        sortDict = {}




        # count ids
        for item in items:
            if item[0] not in ids:
                ids.append(item[0])

        for item in ids:
            sortDict[item] = []
            for j in range(len(items)):
                if items[j][0] == item:
                    sortDict[item].append(items[j][1])
        #print(sortDict)

        sortedDict = {}
        for item in sorted(sortDict.keys()):
            #sortedDict.append([item, sortDict[item]])
            sortedDict[item] = sortDict[item]

        #print(sortedDict)


        sortedList = []
        for item in sortedDict:
            sortedDict[item].sort(reverse=True)
            #sortedList.append([item, sortDict[item]])
            for i in range(len(sortedDict[item])):
                sortedList.append([item, sortedDict[item][i]])
        print(sortedList)
        print(ids)
        ids.sort()
        for i in range(0, len(ids)):
            #print("for id = " , ids[i])
            for j in range(len(sortedList)):

                if sortedList[j][0] == ids[i] and ids[i] not in checked:
                    start = j
                    summ = 0
                    for k in range(start,j+5):
                        summ += sortedList[k][1]
                        #print(summ)
                    sums.append(summ)
                    #print(summ)
                    checked.append(ids[i])
                    #print("checked, ", ids[i])
                else:
                    continue
        #print(sums)
        result = []
        for i in range(len(ids)):
            result.append([ids[i], int(sums[i]/5)])
        print("result = ", result)
        return result