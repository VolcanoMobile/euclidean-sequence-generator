import net.volcanomobile.euclidean.*
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SequenceGeneratorTest {

    @Test
    fun `binaryRightRotate_10 shift 1 equals 01`()
    {
        val value = 2 // 10
        val result = binaryRightRotate(1, value, 2)
        assertEquals(1, result)
    }

    @Test
    fun `binaryRightRotate_11 shift 1 equals 11`()
    {
        val value = 3 // 11
        val result = binaryRightRotate(1, value, 2)
        assertEquals(3, result)
    }

    @Test
    fun `binaryRightRotate_110 shift 1 equals 011`()
    {
        val value = 6 // 110
        val result = binaryRightRotate(1, value, 3)
        assertEquals(3, result)
    }

    @Test
    fun `binaryRightRotate_110 shift 2 equals 101`()
    {
        val value = 6 // 110
        val result = binaryRightRotate(2, value, 3)
        assertEquals(5, result)
    }

    @Test
    fun `readBit_1`()
    {
        assertEquals(1, readBit(3, 0))
    }

    @Test
    fun `readBit_2`()
    {
        assertEquals(1, readBit(3, 1))
    }

    @Test
    fun `readBit_3`()
    {
        assertEquals(0, readBit(3, 2))
    }

    @Test
    fun `readBit_4`()
    {
        assertEquals(0, readBit(2, 0))
    }

    @Test
    fun `findBinaryLenght_1`()
    {
        assertEquals(1, findBinaryLenght(0))
    }

    @Test
    fun `findBinaryLenght_2`()
    {
        assertEquals(1, findBinaryLenght(1))
    }

    @Test
    fun `findBinaryLenght_3`()
    {
        assertEquals(2, findBinaryLenght(2))
    }

    @Test
    fun `findBinaryLenght_4`()
    {
        assertEquals(2, findBinaryLenght(3))
    }

    @Test
    fun `findBinaryLenght_5`()
    {
        assertEquals(3, findBinaryLenght(4))
    }

    @Test
    fun `findBinaryLenght_6`()
    {
        assertEquals(3, findBinaryLenght(6))
    }

    @Test
    fun `concatBinary_1`()
    {
        assertEquals(3, binaryConcat(1, 1))
    }

    @Test
    fun `concatBinary_2`()
    {
        assertEquals(2, binaryConcat(1, 0))
    }

    @Test
    fun `concatBinary_3`()
    {
        assertEquals(6, binaryConcat(1, 2))
    }

    @Test
    fun `concatBinary_4`()
    {
        assertEquals(7, binaryConcat(1, 3))
    }

    @Test
    fun `concatBinary_5`()
    {
        assertEquals(45, binaryConcat(5, 5))
    }

    @Test
    fun `generateSequence_1`()
    {
        assertArrayEquals(booleanArrayOf(true, false, true, false),
            euclideanSequence(4, 2)
        )
    }

    @Test
    fun `generateSequence_2`()
    {
        assertArrayEquals(booleanArrayOf(true, false, false, true, false, false),
            euclideanSequence(6, 2)
        )
    }

    @Test
    fun `generateSequence_3`()
    {
        assertArrayEquals(booleanArrayOf(true, false, false, true, false, true, false, false, true, false, true, false, false),
            euclideanSequence(13, 5)
        )
    }

    @Test
    fun `generateSequence_4`()
    {
        assertArrayEquals(booleanArrayOf(true, false, false, true, false, false, true, false),
            euclideanSequence(8, 3)
        )
    }

    @Test
    fun `generateSequence_5`()
    {
        assertArrayEquals(booleanArrayOf(true, true, true, true, true, false),
            euclideanSequence(6,5)
        )
    }

    @Test
    fun `generateSequence_7`()
    {
        assertArrayEquals(booleanArrayOf(false, false), euclideanSequence(2))
    }

    @Test
    fun `generateSequence_8`()
    {
        assertArrayEquals(booleanArrayOf(), euclideanSequence())
    }

    @Test
    fun `negativeOffset_1`()
    {
        assertArrayEquals(euclideanSequence(6, 5, 5), euclideanSequence(6, 5 , -1))
    }

    @Test
    fun `negativeOffset_2`()
    {
        assertArrayEquals(euclideanSequence(6, 5, 4), euclideanSequence(6, 5, -2))
    }

    @Test
    fun `negativeOffset_3`()
    {
        assertArrayEquals(euclideanSequence(6,5,5), euclideanSequence(6,5,-7))
    }

    @Test
    fun offsetMultipleOfSteps_1()
    {
        assertArrayEquals(booleanArrayOf(true, true, true, true, true, false), euclideanSequence(6,5,12))
    }

    @Test
    fun offsetMultipleOfSteps_2()
    {
        assertArrayEquals(booleanArrayOf(true, true, true, true, true, false), euclideanSequence(6,5,-12))
    }

    @Test
    fun offsetMultipleOfSteps_3()
    {
        assertArrayEquals(booleanArrayOf(true, true, true, true, true, false), euclideanSequence(6,5,-6))
    }

    @Test
    fun offsetLooping()
    {
        assertArrayEquals(booleanArrayOf(false, true, false, false), euclideanSequence(4, 1, 5))
    }
}