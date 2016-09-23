package br.ufscar.dc.secomp;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan ( basePackages = "br.ufscar.dc.secomp.business.impl")
public class AppConfig {
}
