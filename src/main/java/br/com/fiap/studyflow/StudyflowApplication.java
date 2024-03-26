package br.com.fiap.studyflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class StudyflowApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudyflowApplication.class, args);
	}

	@RequestMapping
	@ResponseBody 
	public String home(){
		return "Study Flow";
	}

}
