package com.example.quadriabdulfatai2009003

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import java.io.IOException

class MainActivity : AppCompatActivity() {

    lateinit var mRecyclerView: RecyclerView
    val mAdapter:RecyclerAdapter = RecyclerAdapter()
    lateinit var json:String
    lateinit var deliveriesDataList: List<Deliveries>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gson = Gson()
        json = loadData("Test.json")
        Log.d("JSON", json)
        deliveriesDataList = gson.fromJson(json, Array<Deliveries>::class.java).toList()

        /*for((index) in animeDataList.withIndex()){
            println(animeDataList[index].toString())
        }*/

        setUpRecyclerView()
    }

    fun setUpRecyclerView(){
        mRecyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mAdapter.RecyclerAdapter(getDeliveries(),this)
        mRecyclerView.adapter = mAdapter
    }

    fun getDeliveries() : MutableList<Deliveries>{
        var deliveries : MutableList<Deliveries> = ArrayList()

        for((index) in deliveriesDataList.withIndex()){
            deliveries.add(Deliveries(deliveriesDataList[index].Container,deliveriesDataList[index].General,deliveriesDataList[index].Vehicles, deliveriesDataList[index].Voyage,deliveriesDataList[index].message, deliveriesDataList[index].success))
        }

        //animes.add(Anime(1,"Nombre","Photo","Instrucciones", 1.2F,"Categoria"))
        return deliveries
    }

    fun loadData(inFile: String) : String{
        var tContents = ""

        try{
            val stream = assets.open(inFile)

            val size = stream.available()
            val buffer = ByteArray(size)
            stream.read(buffer)
            stream.close()
            tContents = String(buffer)
        }catch (e: IOException){

        }
        return tContents
    }
}
