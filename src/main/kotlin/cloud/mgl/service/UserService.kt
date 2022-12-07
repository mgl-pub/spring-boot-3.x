package cloud.mgl.service

import cloud.mgl.model.User

interface UserService {
    fun add(user: User)
    fun delete(id: Long)
    fun update(user: User)
    fun query(user: User): MutableList<User>
    fun get(id: Long): User?
}