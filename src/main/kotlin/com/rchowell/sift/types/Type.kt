package com.rchowell.sift.types

import org.apache.arrow.vector.types.FloatingPointPrecision
import org.apache.arrow.vector.types.pojo.ArrowType

/**
 * Minimal type definitions
 *
 * @constructor
 */
enum class Type {
    Bool {
        override val arrow: ArrowType = ArrowType.Bool()
    },
    Num {
        override val arrow: ArrowType = ArrowType.FloatingPoint(FloatingPointPrecision.DOUBLE)
    },
    String {
        override val arrow: ArrowType = ArrowType.Utf8()
    };

    abstract val arrow: ArrowType
}
