package com.example.unittesting

import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test

class TestForEvenNum {
    private lateinit var obj:DemoClass
    @Before
    fun beforeTC(){
        obj=DemoClass()
    }
    @After
    fun afterTC(){
        println("after tc")
    }
    @Test
    fun chkEven(){
        val result=obj.chkEven(1010)
        assertEquals(true,result)
    }
    @Test
    fun chkEven2(){
        val result=obj.chkEven(111)
        assertEquals(false,result)
    }
}