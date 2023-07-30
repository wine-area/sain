package io.nanfeng.common.core.error.infrastructure

import jakarta.validation.ConstraintViolation
import jakarta.validation.ConstraintViolationException
import org.slf4j.LoggerFactory
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE - 1000)
internal class BeanValidationErrorsHandler {
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValid(exception: MethodArgumentNotValidException): ProblemDetail {
        val problem = buildProblemDetail()
        problem.setProperty(ERRORS, buildErrors(exception))
        log.info(exception.message, exception)
        return problem
    }

    private fun buildErrors(exception: MethodArgumentNotValidException): Map<String, String?> {
        return exception
            .bindingResult
            .fieldErrors
            .associate { it.field to it.defaultMessage }
    }

    @ExceptionHandler(ConstraintViolationException::class)
    fun handleConstraintViolationException(exception: ConstraintViolationException): ProblemDetail {
        val problem = buildProblemDetail()
        problem.setProperty(ERRORS, buildErrors(exception))
        log.info(exception.message, exception)


        return problem
    }

    private fun buildProblemDetail(): ProblemDetail {
        val problem = ProblemDetail.forStatusAndDetail(
            HttpStatus.BAD_REQUEST,
            "One or more fields were invalid. See 'errors' for details."
        )
        problem.title = "Bean validation error"
        return problem
    }

    private fun buildErrors(exception: ConstraintViolationException): Map<String, String> {
        return exception
            .constraintViolations
            .associate {
                it.toFieldName() to it.message
            }
    }

    private fun ConstraintViolation<*>.toFieldName(): String {
        val propertyFieldPath = this.propertyPath.toString()
        return propertyFieldPath.substringAfterLast(".")
    }


    companion object {
        private const val ERRORS = "errors"
        private val log = LoggerFactory.getLogger(BeanValidationErrorsHandler::class.java)
    }
}
