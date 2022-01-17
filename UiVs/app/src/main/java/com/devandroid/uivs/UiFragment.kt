package com.devandroid.uivs

import android.content.ContentValues.TAG
import android.content.SharedPreferences
import android.content.res.Resources
import android.icu.text.LocaleDisplayNames
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModelProvider
import com.devandroid.uivs.ViewModel.ViewModelUiVs

import com.devandroid.uivs.databinding.FragmentUiBinding
import java.lang.reflect.Array.getInt

class UiFragment : Fragment() {

    private val binding by lazy { FragmentUiBinding.inflate(layoutInflater) }
    private var sharedPreferences: SharedPreferences? = null
    private lateinit var listGroud: List<GroudObject>
    private lateinit var listItem: Map<GroudObject, List<ItemObject>>
    private lateinit var viewModel: ViewModelUiVs

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: ")
        viewModel = ViewModelProvider(this).get(ViewModelUiVs::class.java)


        binding.RDBSang.setOnClickListener {
            if (binding.RDBSang.isChecked) {
                Log.d("checksang: ", binding.RDBSang.isChecked.toString())
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
        listItem = getListItems()
        listGroud = ArrayList(listItem.keys)
        val customExpandableListAdapter = CustomExpandableListAdapter(listGroud, listItem)
        binding.expandableListView.setAdapter(customExpandableListAdapter)
    }

    private fun getListItems(): Map<GroudObject, List<ItemObject>> {
        val expandableListDetail = HashMap<GroudObject, List<ItemObject>>()

        val objects = GroudObject(3, "Cấu hình chức năng")
        val objects1 = GroudObject(2, "Cấu hình Dashboard")
        val football: MutableList<ItemObject> = ArrayList()
        football.add(ItemObject(1, "duc1"))
        football.add(ItemObject(1, "duc2"))
        football.add(ItemObject(1, "duc3"))
        expandableListDetail.put(objects, football)
        expandableListDetail.put(objects1, football)
        return expandableListDetail
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView: ")
        // Inflate the layout for this fragment
        return binding.root
    }

    companion object {
        fun Instance() = UiFragment()
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d(TAG, "onDestroy: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
    }

}