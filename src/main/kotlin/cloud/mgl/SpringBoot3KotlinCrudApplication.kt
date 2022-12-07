package cloud.mgl

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@MapperScan("cloud.mgl.mapper")
class SpringBoot3KotlinCrudApplication

fun main(args: Array<String>) {
    runApplication<SpringBoot3KotlinCrudApplication>(*args)
}
