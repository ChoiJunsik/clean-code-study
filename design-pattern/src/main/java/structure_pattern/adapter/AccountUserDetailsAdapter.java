package structure_pattern.adapter;

import structure_pattern.adapter.domain.model.AccountUserDetails;
import structure_pattern.adapter.domain.model.UserDetailsModel;
import structure_pattern.adapter.domain.service.AccountService;

/**
 * 1. OCP
 *  - UserDetailsAdapter 클라이언트 코드의 변경없이, 원하는 인터페이스 구현체를 만들어 재사용
 * 2. SRP
 *  - UserDetailsAdapter 는 loadUser 하나만 관리, 매핑 변환 등은 concrete class 몫
 *
 *  다양한 input ~> 동일 core domain return
 */

public class AccountUserDetailsAdapter implements UserDetailsAdapter {

    private final AccountService accountService;

    public AccountUserDetailsAdapter(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public UserDetailsModel loadUser(String username) {
        return new AccountUserDetails(accountService.findAccountByUsername(username));
    }
}
