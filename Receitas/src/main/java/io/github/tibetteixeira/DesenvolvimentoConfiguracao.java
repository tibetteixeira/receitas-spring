package io.github.tibetteixeira;

import io.github.tibetteixeira.annotations.Development;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@Development
public class DesenvolvimentoConfiguracao {

    @Bean
    public CommandLineRunner inicializar() {
        return args -> {
            System.out.println("Aplicação em ambiente de desenvolvimento disponível.");
        };
    }
}
