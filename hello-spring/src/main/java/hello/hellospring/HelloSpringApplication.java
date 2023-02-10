package hello.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args);
	}

	// 시작점
	// component scan 대상은 해당 파일의 패키지를 찾아서 스프링빈으로 등록해 놓은 것
	
}
