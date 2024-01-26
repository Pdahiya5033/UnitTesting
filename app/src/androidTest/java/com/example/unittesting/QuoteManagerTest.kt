package com.example.unittesting

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.gson.JsonSyntaxException
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.FileNotFoundException

class QuoteManagerTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }
    @Test(expected = FileNotFoundException::class)
    fun populateQuoteFromAssets() {
        val quoteManager=QuoteManager()
        val context=ApplicationProvider.getApplicationContext<Context>()
        quoteManager.populateQuoteFromAssets(context,"")
    }
    @Test(expected = JsonSyntaxException::class)
    fun populateQuoteFromAssetsInvalidJSON() {
        val quoteManager=QuoteManager()
        val context=ApplicationProvider.getApplicationContext<Context>()
        quoteManager.populateQuoteFromAssets(context,"invalid.json")
    }
    @Test
    fun populateQuoteFromAssetsCrctFile() {
        val quoteManager=QuoteManager()
        val context=ApplicationProvider.getApplicationContext<Context>()
        quoteManager.populateQuoteFromAssets(context,"quotes.json")
        assertEquals(5,quoteManager.quoteList.size)
    }
    @Test
    fun chkNextQuote(){
        val quoteManager=QuoteManager()
        quoteManager.populateQuotes(arrayOf(
                Quote("sbdvandas sadha","1"),
                Quote("sbdvandas sadha","2"),
                Quote("sbdvandas sadha","3"),
                Quote("sbdvandas sadha","4")
            )
        )
        quoteManager.crntInd=3
        val next=quoteManager.getNextQuote().author
        assertEquals("4",next)
    }
    @Test
    fun chkPrevQuote(){
        val quoteMan=QuoteManager()
        quoteMan.populateQuotes(arrayOf(
            Quote("sbdvandas sadha","1"),
            Quote("sbdvandas sadha","2"),
            Quote("sbdvandas sadha","3"),
            Quote("sbdvandas sadha","4")
        ))
        quoteMan.crntInd=0
        assertEquals("1",quoteMan.getPrevQuote().author)
    }
}