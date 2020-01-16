package net.volcanomobile.euclidean

object SequenceGenerator {

    fun generateSequence(steps: Int, pulses: Int, offset: Int): BooleanArray {
        require(steps >= 0)
        require(steps <= 16)
        require(pulses >= 0)
        require(pulses <= steps)

        if (steps == 0)
            return booleanArrayOf()

        if (pulses == 0)
            return BooleanArray(steps) { false }

        val pauses = steps - pulses
        val perPulse = pauses / pulses
        val remainder = pauses % pulses

        val workbeat = IntArray(steps)
        var workbeatCount = steps

        // Populate workbeat with unsorted pulses and pauses
        for (i in 0 until steps) {
            workbeat[i] = if (i < pulses) 1 else 0
        }

        if (perPulse > 0 && remainder <= 1) {
            // Handle easy cases where there is no or only one remainder
            for (i in 0 until pulses) {
                for (j in workbeatCount - 1 downTo workbeatCount - perPulse) {
                    workbeat[i] = binaryConcat(
                        workbeat[i],
                        workbeat[j]
                    )
                }
                workbeatCount -= perPulse
            }
        } else {
            var groupA = pulses
            var groupB = pauses

            while (groupB > 1)
                when {
                    groupA > groupB -> {
                        val aRemainder = groupA - groupB
                        var trimCount = 0

                        for (i in 0 until groupA - aRemainder) {
                            workbeat[i] = binaryConcat(
                                workbeat[i],
                                workbeat[workbeatCount - 1 - i]
                            )
                            trimCount++
                        }

                        workbeatCount -= trimCount
                        groupA = groupB
                        groupB = aRemainder
                    }
                    groupB > groupA -> {
                        val bRemainder = groupB - groupA
                        var trimCount = 0

                        for (i in workbeatCount - 1 downTo groupA + bRemainder) {
                            workbeat[workbeatCount - i - 1] =
                                binaryConcat(
                                    workbeat[workbeatCount - i - 1],
                                    workbeat[i]
                                )
                            trimCount++
                        }

                        workbeatCount -= trimCount
                        groupB = bRemainder
                    }
                    else -> {
                        var trimCount = 0

                        for (i in 0 until groupA) {
                            workbeat[i] = binaryConcat(
                                workbeat[i],
                                workbeat[workbeatCount - 1 - i]
                            )
                            trimCount++
                        }

                        workbeatCount -= trimCount
                        groupB = 0
                    }
                }
        }

        var outBeat = 0
        // Concatenate workbeat into outBeat - according to workbeatCount
        for (i in 0 until workbeatCount) {
            outBeat =
                binaryConcat(outBeat, workbeat[i])
        }

        if (offset != 0 && offset % steps != 0) {
            outBeat = binaryRightRotate(
                offset,
                outBeat,
                steps
            )
        }

        return BooleanArray(steps) { i -> readBit(
            outBeat,
            (steps - 1) - i
        ) == 1 }
    }

    internal fun binaryRightRotate(shift: Int, value: Int, patternLenght: Int): Int {
        require(patternLenght > 1)
        require(value > 0)

        var offset = shift
        while (offset < 0)
            offset += patternLenght

        val mask = (1 shl patternLenght) - 1
        val maskedValue = value and mask
        return ((maskedValue ushr offset) or (maskedValue shl (patternLenght - offset))) and mask
    }

    internal fun findBinaryLenght(value: Int): Int {
        require(value >= 0)

        var lengthFound = false
        var length = 1

        for (q in 31 downTo  0) {
            val bit = readBit(value, q)
            if (bit == 1 && !lengthFound) {
                length = q + 1
                lengthFound = true
            }
        }

        return length
    }

    internal fun readBit(value: Int, bit: Int): Int {
        require(bit >= 0)
        require(bit < 32)
        require(value >= 0)

        return if ((1 shl bit) and value != 0) 1 else 0
    }

    internal fun binaryConcat(a: Int, b: Int): Int {
        require(a >= 0)
        require(b >= 0)

        val bLenght = findBinaryLenght(b)
        return a shl bLenght or b
    }
}