package com.apap.sudoku.util

class Board {

    class Row(val size: Int = 9) {
        private var digits: IntArray = IntArray(size)

        val indices = digits.indices

        fun get() : IntArray = digits
        operator fun get(index: Int) = digits[index]

        @JvmName("set-vararg")
        fun set(vararg digits: Int) {
            this.digits = digits
        }

        @JvmName("set-intArray")
        fun set(digits: IntArray) {
            this.digits = digits
        }

        operator fun set(digit: Int, index: Int) {
            this.digits[index] = digit
        }

        fun contentToString() = digits.contentToString()
        fun sliceArray(indices: IntRange) = digits.sliceArray(indices)
    }
}