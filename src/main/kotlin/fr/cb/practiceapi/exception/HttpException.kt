package fr.cb.practiceapi.exception

open class HttpException(status: Int, msg: String) : Exception("HTTP Exception, status $status : $msg")