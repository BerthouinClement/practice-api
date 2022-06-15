package fr.cb.practiceapi.exception

import org.springframework.http.HttpStatus

class NotFoundException(val msg: String) : HttpException(HttpStatus.NOT_FOUND.value(), msg)