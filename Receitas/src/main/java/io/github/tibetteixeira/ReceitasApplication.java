package io.github.tibetteixeira;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ReceitasApplication {

    @Autowired
    @Qualifier("nomeDaAplicacao")
    private String nomeDaAplicacao;

    @Value("${aplicacao.versao}")
    private String versao;

    @Value("${aplicacao.build}")
    private String build;

    @GetMapping("/info")
    public String infomacaoDaAplicacao() {
        return String.format("%s - v%s.%s", nomeDaAplicacao, versao, build);
    }

    public static void main(String[] args) {
        SpringApplication.run(ReceitasApplication.class, args);
    }
}
