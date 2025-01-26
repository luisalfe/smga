package com.smga.smga.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
public class LoggingFilter implements WebFilter {

    private static final Logger logger = LoggerFactory.getLogger(LoggingFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        // Log de la solicitud entrante
        logger.info("Solicitud entrante: {} {}", exchange.getRequest().getMethod(), exchange.getRequest().getURI());

        // Continua con el siguiente filtro en la cadena
        return chain.filter(exchange).doFinally(signalType -> {
            // Log de la respuesta cuando se completa
            logger.info("Respuesta: {} - {}", exchange.getResponse().getStatusCode(), exchange.getRequest().getURI());
        });
    }
}


