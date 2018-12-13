package sort

class Selection {

    fun sort(list: IntArray): IntArray {

        val limit = list.size - 1

        for (i in 0..limit) {

            var minIndex = i

            for (j in (i + 1)..limit) {

                if (list[j] < list[minIndex]) {
                    minIndex = j
                }
            }

            val t = list[i]
            list[i] = list[minIndex]
            list[minIndex] = t
        }

        return list
    }

}