package com.extensions

import android.view.View

fun View.setVisibility(shouldHide: Boolean) {
    this.visibility = if (shouldHide) View.GONE else View.VISIBLE
}