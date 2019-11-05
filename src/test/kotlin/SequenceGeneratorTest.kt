import net.volcanomobile.euclidian.SequenceGenerator
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SequenceGeneratorTest {

    @Test
    fun `binaryRightRotate_10 shift 1 equals 01`()
    {
        val value = 2 // 10
        val result = SequenceGenerator.binaryRightRotate(1, value, 2)
        assertEquals(1, result)
    }

    @Test
    fun `binaryRightRotate_11 shift 1 equals 11`()
    {
        val value = 3 // 11
        val result = SequenceGenerator.binaryRightRotate(1, value, 2)
        assertEquals(3, result)
    }

    @Test
    fun `binaryRightRotate_110 shift 1 equals 011`()
    {
        val value = 6 // 110
        val result = SequenceGenerator.binaryRightRotate(1, value, 3)
        assertEquals(3, result)
    }

    @Test
    fun `binaryRightRotate_110 shift 2 equals 101`()
    {
        val value = 6 // 110
        val result = SequenceGenerator.binaryRightRotate(2, value, 3)
        assertEquals(5, result)
    }

    @Test
    fun `readBit_1`()
    {
        assertEquals(1, SequenceGenerator.readBit(3, 0))
    }

    @Test
    fun `readBit_2`()
    {
        assertEquals(1, SequenceGenerator.readBit(3, 1))
    }

    @Test
    fun `readBit_3`()
    {
        assertEquals(0, SequenceGenerator.readBit(3, 2))
    }

    @Test
    fun `readBit_4`()
    {
        assertEquals(0, SequenceGenerator.readBit(2, 0))
    }

    @Test
    fun `findBinaryLenght_1`()
    {
        assertEquals(1, SequenceGenerator.findBinaryLenght(0))
    }

    @Test
    fun `findBinaryLenght_2`()
    {
        assertEquals(1, SequenceGenerator.findBinaryLenght(1))
    }

    @Test
    fun `findBinaryLenght_3`()
    {
        assertEquals(2, SequenceGenerator.findBinaryLenght(2))
    }

    @Test
    fun `findBinaryLenght_4`()
    {
        assertEquals(2, SequenceGenerator.findBinaryLenght(3))
    }

    @Test
    fun `findBinaryLenght_5`()
    {
        assertEquals(3, SequenceGenerator.findBinaryLenght(4))
    }

    @Test
    fun `findBinaryLenght_6`()
    {
        assertEquals(3, SequenceGenerator.findBinaryLenght(6))
    }

    @Test
    fun `concatBinary_1`()
    {
        assertEquals(3, SequenceGenerator.binaryConcat(1, 1))
    }

    @Test
    fun `concatBinary_2`()
    {
        assertEquals(2, SequenceGenerator.binaryConcat(1, 0))
    }

    @Test
    fun `concatBinary_3`()
    {
        assertEquals(6, SequenceGenerator.binaryConcat(1, 2))
    }

    @Test
    fun `concatBinary_4`()
    {
        assertEquals(7, SequenceGenerator.binaryConcat(1, 3))
    }

    @Test
    fun `concatBinary_5`()
    {
        assertEquals(45, SequenceGenerator.binaryConcat(5, 5))
    }

    @Test
    fun `generateSequence_1`()
    {
        assertArrayEquals(booleanArrayOf(true, false, true, false), SequenceGenerator.generateSequence(4,2,0))
    }

    @Test
    fun `generateSequence_2`()
    {
        assertArrayEquals(booleanArrayOf(true, false, false, true, false, false), SequenceGenerator.generateSequence(6,2,0))
    }

    @Test
    fun `generateSequence_3`()
    {
        assertArrayEquals(booleanArrayOf(true, false, false, true, false, true, false, false, true, false, true, false, false), SequenceGenerator.generateSequence(13,5,0))
    }

    @Test
    fun `generateSequence_4`()
    {
        assertArrayEquals(booleanArrayOf(true, false, false, true, false, false, true, false), SequenceGenerator.generateSequence(8,3,0))
    }

    @Test
    fun `generateSequence_5`()
    {
        assertArrayEquals(booleanArrayOf(true, true, true, true, true, false), SequenceGenerator.generateSequence(6,5,0))
    }

    @Test
    fun `generateSequence_7`()
    {
        assertArrayEquals(booleanArrayOf(false, false), SequenceGenerator.generateSequence(2,0,0))
    }

    @Test
    fun `generateSequence_8`()
    {
        assertArrayEquals(booleanArrayOf(), SequenceGenerator.generateSequence(0,0,0))
    }
}