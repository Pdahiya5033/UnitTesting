package com.example.unittesting

class DemoClass {
    fun chkEven(num:Int):Boolean{
        if(num%2==0)
            return true
        return false
    }
    fun chkPassword(password:String):Boolean{
        if(password.isEmpty())
            return false
        if(password.length<6||password.length>15)
            return false
        return true
    }
}