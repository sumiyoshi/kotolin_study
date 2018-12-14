package sort

class Selection {

    fun sort(list: IntArray): IntArray {

        var sortList = list.clone()
        val lastIndex = list.lastIndex

        for (i in 0..lastIndex) {

            var minIndex = i

            for (j in (i + 1)..lastIndex) {

                if (sortList[j] < sortList[minIndex]) {
                    minIndex = j
                }
            }

            sortList = switch(sortList, minIndex, i)
        }

        return sortList
    }

}