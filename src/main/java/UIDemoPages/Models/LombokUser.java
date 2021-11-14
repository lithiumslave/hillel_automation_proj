package UIDemoPages.Models;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LombokUser {

    private String userName;
    private String userPassword;
}
