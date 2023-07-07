package io.nanfeng.common.web

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler


@RestControllerAdvice
class BizExceptionHandler : ResponseEntityExceptionHandler() {


    @ExceptionHandler(Exception::class)
    fun handleBizException(ex: Exception, request: WebRequest): ResponseEntity<Any>? {
        val body = createProblemDetail(
            ex,
            INTERNAL_SERVER_ERROR,
            ex.message ?: "",
            "300012", arrayOf(), request
        )
        val headers = HttpHeaders()
        return handleExceptionInternal(ex, body, headers, INTERNAL_SERVER_ERROR, request)
    }

}