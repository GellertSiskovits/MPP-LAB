package networking.utils;

import networking.dto.UserDTO;

public class LogoutRequest implements Request{
    private UserDTO user;

    public LogoutRequest(UserDTO user) {
        this.user = user;
    }

    public UserDTO getUser() {
        return user;
    }
}
