package cloud.mgl.service.impl

import cloud.mgl.mapper.UserMapper
import cloud.mgl.model.User
import cloud.mgl.service.UserService
import cn.hutool.core.bean.BeanUtil
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl: UserService {

    @Autowired
    private lateinit var mapper: UserMapper


    override fun add(user: User) {
        mapper.insert(user)
    }

    override fun delete(id: Long) {
        mapper.deleteById(id)
    }

    override fun update(user: User) {
        mapper.updateById(user)
    }

    override fun query(user: User): MutableList<User> {

        val params = QueryWrapper<User?>()

        val userMap = BeanUtil.beanToMap(user,false,true)

        params.allEq(userMap)

        val list = mapper.selectList(params)


        list.forEach {
            println(it.age)
        }
        return list
    }

    override fun get(id: Long): User? {
        return mapper.selectById(id)
    }
}