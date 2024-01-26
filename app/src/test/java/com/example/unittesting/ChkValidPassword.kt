package com.example.unittesting

import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(value = Parameterized::class)
class ChkValidPassword(private val input:String,private val expected:Boolean) {
    @Test
    fun chkValidityPass(){
        val obj=DemoClass()
        val res=obj.chkPassword(input)
        assertEquals(expected,res)
    }

    companion object{
        @JvmStatic
        @Parameterized.Parameters
        fun giveData():List<Array<Any>>{
            return listOf(
                arrayOf("",false),
                arrayOf("dasa",false),
                arrayOf("dsasdff",true),
                arrayOf("xznbczcvbxcxbbnff",false)
            )
        }
    }
}