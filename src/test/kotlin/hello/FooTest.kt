import org.junit.Assert.*
import org.junit.*
import com.sumilab.Case
import hello.Name

class FooTest {

    @Test
    fun testCase() {
        assertEquals(Case.toCamel("test_test"), "testTest")
        assertEquals(Case.toPascal("test_test"), "TestTest")
    }

    @Test
    fun testInlineClass()
    {
        val name = Name("Name!")
        assertEquals(name.equals(name), true)
        assertNotEquals(name.equals("Name!"), true)
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
