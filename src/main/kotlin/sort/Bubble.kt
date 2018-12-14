package sort

class Bubble {

    fun sort(list: IntArray): IntArray {
        return sort(list, list.lastIndex)
    }

    private fun sort(list: IntArray, index: Int): IntArray {

        if (index == 0) {
            return list
        }

        val sortList = runSort(list, index)
        return sort(sortList, index - 1)
    }

    private fun runSort(list: IntArray, index: Int): IntArray {

        var sortList = list.clone()

        for (j in 1..index) {
            if (sortList[j - 1] > sortList[j]) {
                sortList = switch(sortList, j - 1, j)
            }
        }

        return sortList
    }

}