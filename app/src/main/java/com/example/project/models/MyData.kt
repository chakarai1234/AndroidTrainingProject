package com.example.project.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MyData(val name: String, val age: String) : Parcelable
