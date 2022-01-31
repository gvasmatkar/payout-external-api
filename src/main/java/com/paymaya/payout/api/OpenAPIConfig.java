package com.paymaya.payout.api;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "payout-external-api",
                version = "v2.0"
        ),
        servers = @Server(url = "http://payout-external-api:8081")
)
public class OpenAPIConfig {
}
