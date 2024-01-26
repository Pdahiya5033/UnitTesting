package com.example.unittesting

import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(value=Parameterized::class)
class ParameterizedTest(private val input:Int, private val expected:Boolean) {
    @Test
    fun chkForEven(){
        val obj=DemoClass()
        assertEquals(expected,obj.chkEven(input))
    }
    companion object{
        @JvmStatic
        @Parameterized.Parameters
        fun data():List<Array<Any>>{
            return listOf(
                arrayOf(10,true),
                arrayOf(11,false),
                arrayOf(0,true),
                arrayOf(1,false),
                arrayOf(3,false)
            )
        }
    }
}