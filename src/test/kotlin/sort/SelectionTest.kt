package sort

import org.junit.Assert
import org.junit.Test

class SelectionTest {

    @Test
    fun testSort1() {
        val list: IntArray = intArrayOf(3, 1, 2)
        val selection = Selection()
        Assert.assertArrayEquals(selection.sort(list), intArrayOf(1, 2, 3))
    }

    @Test
    fun testSort2() {
        val list: IntArray = intArrayOf(3, 2, 1)
        val selection = Selection()
        Assert.assertArrayEquals(selection.sort(list), intArrayOf(1, 2, 3))
    }

}