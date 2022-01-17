package com.devandroid.uivs

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.graphics.Typeface

import android.R

import android.widget.TextView

import android.view.LayoutInflater

class CustomExpandableListAdapter(
    private var listgroud: List<GroudObject>,
    private var listItem: Map<GroudObject, List<ItemObject>>
) : BaseExpandableListAdapter() {

    override fun getGroupCount(): Int {

        if (listgroud != null) {
            return listgroud.size
        } else {
            return 0
        }
    }

    override fun getChildrenCount(groupPosition: Int): Int {

        return listItem.get(listgroud.get(groupPosition))!!.size

    }

    override fun getGroup(groupPosition: Int): Any {
        return listgroud.get(groupPosition)
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {

        return listItem.get(listgroud.get(groupPosition))!!.get(childPosition)
    }

    override fun getGroupId(groupPosition: Int): Long {
        val objects1: GroudObject = listgroud.get(groupPosition)
        return objects1.id.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        val itemObject: ItemObject = listItem.get(listgroud.get(groupPosition))!!.get(childPosition)
        return itemObject.id.toLong()
    }


    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View? {
        val objects1: GroudObject = listgroud.get(groupPosition)
        var convertView = convertView
        if (convertView == null) {
            val inflater =
                parent!!.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(com.devandroid.uivs.R.layout.ground, null)
        }
        val title = convertView!!.findViewById<TextView>(com.devandroid.uivs.R.id.title)
        title.text = objects1.name
        return convertView
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val itemObject=listItem.get(listgroud.get(groupPosition))!!.get(childPosition)
        var convertView = convertView
        if (convertView == null) {
            val inflater =
                parent!!.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(com.devandroid.uivs.R.layout.list_item, null)
        }
        val title = convertView!!.findViewById<TextView>(com.devandroid.uivs.R.id.expandedListItem)
        title.text = itemObject.name
        return convertView
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }

}

