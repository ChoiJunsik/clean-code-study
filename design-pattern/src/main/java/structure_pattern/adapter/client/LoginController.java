package structure_pattern.adapter.client;

import structure_pattern.adapter.domain.model.UserDetailsModel;
import structure_pattern.adapter.UserDetailsAdapter;

/**
 * Client
 */
public class LoginController {

    UserDetailsAdapter userDetailsAdapter;

    public LoginController(final UserDetailsAdapter userDetailsAdapter) {
        this.userDetailsAdapter = userDetailsAdapter;
    }

    public String login(final String username, final String password) {
        UserDetailsModel userDetailsModel = userDetailsAdapter.loadUser(username);
        if (userDetailsModel.getPassword().equals(password)) {
            return userDetailsModel.getUsername();
        } else {
            throw new IllegalArgumentException();
        }
    }
}
