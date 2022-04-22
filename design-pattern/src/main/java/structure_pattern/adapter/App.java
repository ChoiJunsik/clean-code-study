package structure_pattern.adapter;

import structure_pattern.adapter.client.LoginController;
import structure_pattern.adapter.domain.service.AccountService;

public class App {

	public static void main(String[] args) {
		final AccountService accountService = new AccountService();
		final AccountUserDetailsAdapter adapter = new AccountUserDetailsAdapter(
				accountService);

		final LoginController loginController = new LoginController(adapter);

		final String userName = loginController.login("junsik.choi", "junsik.choi");
		System.out.println("userName = " + userName);
	}
}
