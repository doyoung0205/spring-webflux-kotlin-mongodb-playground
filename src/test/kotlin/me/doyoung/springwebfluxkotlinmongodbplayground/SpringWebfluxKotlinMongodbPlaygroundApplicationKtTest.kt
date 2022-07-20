package me.doyoung.springwebfluxkotlinmongodbplayground

import me.doyoung.springwebfluxkotlinmongodbplayground.greeting.Greeting
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.reactive.server.WebTestClient

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
internal class SpringWebfluxKotlinMongodbPlaygroundApplicationKtTest(
    @Autowired private val webTestClient: WebTestClient
) {

    @Test
    fun testHello() {
        webTestClient
            .get().uri("/hello")
            .accept(MediaType.APPLICATION_JSON)
            .exchange() // and use the dedicated DSL to test assertions against the response
            .expectStatus().isOk
            .expectBody(Greeting::class.java)
            .value { greeting -> assertThat(greeting.message).isEqualTo("Hello, Spring!") }
    }
}
