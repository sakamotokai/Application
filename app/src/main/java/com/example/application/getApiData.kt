package com.example.application

import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.application.databinding.ActivityMainBinding
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.Observables
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

    fun getData_cat2(text: TextView) {
        val url =
            "https://catfact.ninja/fact"
        var info = "\\\\"
        val queue = Volley.newRequestQueue(text.context)
        val stringRequest = StringRequest(Request.Method.GET, url, {
            val obj = JSONObject(it)
            info = obj.getString("fact")
            text.text = info
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
                view.text = coin.getString("rate") + coin.getString("code")
            }, {})
            queue.add(stringRequest)
        }.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        thread.subscribe()
    }

    fun getDopData_bitcoin(view: TextView, info: String) {
        val thread = Observable.create<String> {
            val url = "https://api.coindesk.com/v1/bpi/currentprice.json"
            val queue = Volley.newRequestQueue(view.context)
            val stringRequest = StringRequest(Request.Method.GET, url, {
                val odj = JSONObject(it)
                val bpi = odj.getJSONObject("bpi")
                view.text = bpi.getString(info).replace("\",\"", "\n").replace(
                    "\"", "").replace("{","").replace("}","")
            }, {})
            queue.add(stringRequest)
        }.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        thread.subscribe()
    }

}