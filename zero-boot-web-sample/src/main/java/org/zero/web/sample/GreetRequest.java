package org.zero.web.sample;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class GreetRequest implements Serializable {
    private long id;
    @NotNull
    private String content;
}
