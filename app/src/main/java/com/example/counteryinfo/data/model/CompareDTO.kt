package com.example.counteryinfo.data.model

data class CompareDTO(
    val name: String?=null,
    val rate: String?=null
    // there ?=null is using to the data pass tha null from Api server so app do not crash
)
