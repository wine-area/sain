package io.nanfeng.user.biz.resource

import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("users")
@Tag(name = "用户管理")
class UserController {

    @PreAuthorize("hasPermission('user', 'read')")
    @GetMapping("info")
    fun userInfo() {

    }
}