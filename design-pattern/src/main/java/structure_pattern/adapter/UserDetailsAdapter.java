package structure_pattern.adapter;

import structure_pattern.adapter.domain.model.UserDetailsModel;

public interface UserDetailsAdapter {

    UserDetailsModel loadUser(String username);

}
