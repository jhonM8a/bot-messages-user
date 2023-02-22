package com.jochoa.bot;

import com.jochoa.bot.conf.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class BotApplication {

	public static void main(String[] args) {

		SpringApplication.run(BotApplication.class, args);
	}

}
