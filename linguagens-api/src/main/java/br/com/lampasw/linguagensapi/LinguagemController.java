package br.com.lampasw.linguagensapi;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinguagemController {

	private List<Linguagem> linguagens = 
			List.of(
					new Linguagem("Java", "https://ensinado.com.br/wp-content/uploads/2021/06/java_logo_640.jpg", 1),
					new Linguagem("PHP", "https://static.imasters.com.br/wp-content/uploads/2018/06/22153245/php-post-1.png", 2)
					);
			
	@GetMapping("/linguagens")
	public List<Linguagem> obterLinguagens() {
		return linguagens;
	}
}
