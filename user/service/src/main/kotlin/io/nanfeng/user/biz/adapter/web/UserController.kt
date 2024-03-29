package io.nanfeng.user.biz.adapter.web

import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("users")
@Tag(name = "用户管理")
class UserController {

//    @PreAuthorize("hasPermission('user', 'read')")
    @GetMapping("info")
    fun userInfo() {
        throw RuntimeException("test")
    }
}