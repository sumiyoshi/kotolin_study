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
    
    @Test
    fun testScopeFunction() {

        val name = "some name"

        assertEquals("some name".let { it.toUpperCase() }, "SOME NAME")
        assertEquals("some name".run { toUpperCase() }, "SOME NAME")
        assertEquals("some name".apply { toUpperCase() }, "some name")
        assertEquals("some name".also { it.toUpperCase() }, "some name")

        class Data(var name: String)
        val _data1 = Data(name)
        val _data2 = Data(name)

        val data1 = _data1.apply { this.name = name.toUpperCase() }
        val data2 = _data2.also { it.name = it.name.toUpperCase() }

        assertEquals(data1.name, "SOME NAME")
        assertEquals(data2.name, "SOME NAME")
    }

}
