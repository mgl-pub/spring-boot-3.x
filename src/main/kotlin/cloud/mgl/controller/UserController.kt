package cloud.mgl.controller

import cloud.mgl.model.User
import cloud.mgl.service.UserService
import cn.hutool.json.JSONUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {


    @Autowired
    private lateinit var service: UserService

    @GetMapping("/")
    fun home(user: User): String {
        val list = service.query(user)
        return JSONUtil.toJsonStr(list)
    }

    @PutMapping("/")
    fun put(user: User): String {
        service.update(user)
        return JSONUtil.toJsonStr("成功")
    }

    @PostMapping("/")
    fun post(user: User): String {
        service.add(user)
        return JSONUtil.toJsonStr("成功")
    }

    @GetMapping("/{id}")
    fun get(@PathVariable("id") id: Long): String {
        val user = service.get(id)
        return JSONUtil.toJsonStr(user)
    }

}