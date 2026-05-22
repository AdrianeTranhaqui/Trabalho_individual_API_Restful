package org.serratec.cursos.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
        .info(new Info()
           .title("Plataforma de Cursos Comunitários API")
           .description("API RESTful para gerenciamento de cursos comunitários, alunos, professores e matrículas."));
    }
}
