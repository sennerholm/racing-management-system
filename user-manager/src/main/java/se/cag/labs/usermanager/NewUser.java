package se.cag.labs.usermanager;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NewUser {
    private String userId;
    private String displayName;
    private String password;
}
