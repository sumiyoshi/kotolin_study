package sort

fun switch(list: IntArray, index1: Int, index2: Int): IntArray {

    val newList = list.clone()

    val t = newList[index1]
    newList[index1] = newList[index2]
    newList[index2] = t

    return newList
}