package me.sungbin.demospringboot22;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.util.unit.DataSize;

@Getter
@AllArgsConstructor
@ConstructorBinding
@ConfigurationProperties(prefix = "chicken")
public class ChickenProperties {

    private int count;

    private String name;

    private DataSize size;
}
