package me.doyoung.springwebfluxkotlinmongodbplayground

import me.doyoung.springwebfluxkotlinmongodbplayground.greeting.GreetingClient
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringWebfluxKotlinMongodbPlaygroundApplication

fun main(args: Array<String>) {
    val applicationContext = runApplication<SpringWebfluxKotlinMongodbPlaygroundApplication>(*args)
    val greetingClient = applicationContext.getBean(GreetingClient::class.java)
    println(">> message = " + greetingClient.getMessage().block());
}
