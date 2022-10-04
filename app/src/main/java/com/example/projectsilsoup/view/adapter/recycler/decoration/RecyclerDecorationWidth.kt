package com.example.projectsilsoup.view.adapter.recycler.decoration

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class RecyclerDecorationWidth(private val divWidth: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        if(parent.getChildAdapterPosition(view) % 2 == 0 || parent.getChildAdapterPosition(view) == 0){
            outRect.left = divWidth
        }
    }
}