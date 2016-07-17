package br.com.wamais.houseCare.form;

public class LoginForm implements IForm {

	private static final long serialVersionUID = 1838432323693268625L;
	private String user;
	private String pass;

	public String getUser() {

		return this.user;
	}

	public void setUser(final String email) {

		this.user = email;
	}

	public String getPass() {

		return this.pass;
	}

	public void setPass(final String pass) {

		this.pass = pass;
	}

}
