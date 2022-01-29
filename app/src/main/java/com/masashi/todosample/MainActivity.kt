package com.masashi.todosample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.masashi.todosample.databinding.ActivityMainBinding
import io.realm.Realm
import io.realm.RealmChangeListener
import io.realm.RealmResults
import java.util.*

/**
 * Created by Masashi Hamaguchi on 2022/01/29.
 */

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val realm: Realm by lazy {
        Realm.getDefaultInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val results = realm.where(Task::class.java).findAll()
        val taskList: MutableList<Task>? = results.toMutableList()
        val adapter = CustomAdapter(taskList)

        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        results.addChangeListener(RealmChangeListener<RealmResults<Task>> {
            Log.d("listener", it.size.toString())
            taskList?.clear()
            taskList?.addAll(it.toMutableList())
            adapter.notifyDataSetChanged()
        })

        binding.button.setOnClickListener {
            val title = binding.textInputEditText.text.toString()
            if (title != "") {
                createTask(title)
                binding.textInputEditText.setText("")
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }

    private fun createTask(title: String) {
        realm.executeTransaction {
            val task = it.createObject(Task::class.java, UUID.randomUUID().toString())
            task.title = title
            task.memo = "※メモ※"
        }
        Log.d("create", title)
    }

}
