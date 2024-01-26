package com.example.unittesting

import android.content.Context
import com.google.gson.Gson

class QuoteManager() {
    var quoteList= emptyArray<Quote>()
    var crntInd=0
    fun populateQuoteFromAssets(context: Context, fileName:String){
        val inputStream=context.assets.open(fileName)
        val size:Int=inputStream.available()
        val buffer=ByteArray(size)
        inputStream.read()
        inputStream.close()
        val json=String(buffer,Charsets.UTF_8)
        val gson=Gson()
        quoteList=gson.fromJson(json,Array<Quote>::class.java)
    }
    fun populateQuotes(quotes:Array<Quote>){
        quoteList=quotes
    }
    fun getCrntQuote():Quote{
        return quoteList[crntInd]
    }
    fun getNextQuote():Quote{
        if(crntInd==quoteList.size-1)
            return quoteList[crntInd]
        return quoteList[++crntInd]
    }
    fun getPrevQuote():Quote{
        if(crntInd==0)
            return quoteList[crntInd]
        return quoteList[--crntInd]
    }
}