package com.example.application

import android.widget.TextView
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.json.JSONObject

class getApiData {

    fun getData_cat(text: TextView) {
        val url =
            "https://catfact.ninja/fact"
        val queue = Volley.newRequestQueue(text.context)
        val stringRequest = StringRequest(Request.Method.GET, url, {
            val obj = JSONObject(it)
            text.text = obj.getString("fact")
        }, {

        })
        queue.add(stringRequest)
    }

    fun getData_bitcoin(view: TextView, coin: String) {
        val thread = Observable.create<String> {
            val url = "https://api.coindesk.com/v1/bpi/currentprice.json"
            val queue = Volley.newRequestQueue(view.context)
            val stringRequest = StringRequest(Request.Method.GET, url, {
                val odj = JSONObject(it)
                val bpi = odj.getJSONObject("bpi")
                val coin = bpi.getJSONObject(coin)
                staticBitcoin.returnData = coin.getString("rate") + coin.getString("code")
                view.text = staticBitcoin.returnData
            }, {})
            queue.add(stringRequest)
        }.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        thread.subscribe()
    }

    fun getDopData_bitcoin(view: TextView, info: String) {
            val url = "https://api.coindesk.com/v1/bpi/currentprice.json"
            val queue = Volley.newRequestQueue(view.context)
            val stringRequest = StringRequest(Request.Method.GET, url, {
                val odj = JSONObject(it)
                val bpi = odj.getJSONObject("bpi")
                staticBitcoin.bitcoinInfoData = bpi.getString(info).replace("\",\"", "\n").replace(
                    "\"", "").replace("{","").replace("}","")
                view.text = staticBitcoin.bitcoinInfoData
            }, {})
            queue.add(stringRequest)
    }

}