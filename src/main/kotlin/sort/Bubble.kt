package sort

class Bubble {

    fun sort(list: IntArray): IntArray {
        return sort(list, list.size - 1)
    }

    fun sort(list: IntArray, index: Int): IntArray {
        return if (index == 0) list
        else sort(runSort(list, index), index - 1)
    }

    private fun runSort(list: IntArray, index: Int): IntArray {

        for (j in 1..index) {
            if (list[j - 1] > list[j]) {
                val t = list[j - 1]
                list[j - 1] = list[j]
                list[j] = t
            }
        }

        return list
    }

}