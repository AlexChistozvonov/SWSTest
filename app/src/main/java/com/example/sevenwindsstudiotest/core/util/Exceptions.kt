package com.example.sevenwindsstudiotest.core.util

open class ExceptionTest : Exception()

class NetworkException : ExceptionTest()
class TimeoutException : ExceptionTest()
class GeneralException(val value: String? = "", val code: Int? = null) : ExceptionTest()
class ServerException(val errorCode: Int? = null) : ExceptionTest()
