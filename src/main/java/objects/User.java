package objects;

import lombok.Data;

import java.util.UUID;


@Data
public class User {

    private UUID uuid;
    private String name;
    private String lastName;
    private String secondName;


}
