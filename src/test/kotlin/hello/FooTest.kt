import org.junit.Assert.*
import org.junit.*
import hello.*

class FooTest {

    @Test
    fun testMethod1() {
        val foo = Foo()
        assertEquals("test1", foo.method1())
    }

    @Test
    fun testMethod2() {
        val foo = Foo()
        assertEquals("test2", foo.method2())
    }

}