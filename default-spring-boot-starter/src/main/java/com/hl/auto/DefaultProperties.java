package com.hl.auto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties("hl.redis")
public class DefaultProperties {
    private int database;
    private String url;
    private String host;
    private String password;
    private int port;

}
