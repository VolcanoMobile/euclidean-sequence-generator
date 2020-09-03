package net.volcanomobile.euclidean.builder

import net.volcanomobile.euclidean.SequenceGenerator
import net.volcanomobile.euclidean.SequenceGeneratorDsl

@SequenceGeneratorDsl
internal class SequenceGeneratorBuilder constructor(
    val steps: Int = 0, val pulses: Int = 0, val offset: Int = 0)
{
    fun build(): SequenceGenerator
    {
        require(steps >= 0)
        require(steps <= 16)
        require(pulses >= 0)
        require(pulses <= steps)

        return SequenceGenerator(steps, pulses, offset)
    }
}