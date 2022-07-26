package io.github.tibetteixeira;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfiguration {

    @Value("${aplicacao.nome}")
    private String nomeAplicacao;

    @Bean
    public String nomeDaAplicacao() {
        return nomeAplicacao;
    }
}
