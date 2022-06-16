package fr.cb.practiceapi

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
class PracticeapiApplication

fun main(args: Array<String>) {
	runApplication<PracticeapiApplication>(*args)
}
