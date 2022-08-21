package com.mycompany.learningkotlin.utils

sealed class Resource<T>(
    val data:T?=null,
    val message:T?=null
){
    class Sucess<T>(data: T?):Resource<T>(data)
    class Error<T>(message: T?,data: T?=null):Resource<T>(data,message)
    class Loading<T>():Resource<T>()
}