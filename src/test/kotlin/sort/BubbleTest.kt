import org.junit.Assert.*
import org.junit.*
import sort.*

class BubbleTest {

    @Test
    fun testSort1() {
        val list: IntArray = intArrayOf(3, 1, 2)
        val bubble = Bubble()
        assertArrayEquals(bubble.sort(list), intArrayOf(1, 2, 3))
    }

    @Test
    fun testSort2() {
        val list: IntArray = intArrayOf(3, 2, 1)
        val bubble = Bubble()
        assertArrayEquals(bubble.sort(list), intArrayOf(1, 2, 3))
    }

}