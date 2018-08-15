package com.javano;

import java.io.IOException;

import com.github.kevinsawicki.http.HttpRequest;
import com.google.gson.Gson;
import com.javano.request.accounts.AccountBalanceRequest;
import com.javano.response.accounts.AccountBalanceResponse;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NanoClient {

	private String address;
	private Gson gson;
	
	public NanoClient() {
		this("http://127.0.0.1:7076");		
	}
	
	public NanoClient(String address) {
		this.address = address;
		gson = new Gson();
	}
	
	public AccountBalanceResponse getAccounBalance(String account) throws IOException {
		return gson.fromJson(HttpRequest.post(address).send(gson.toJson(new AccountBalanceRequest(account))).body(), AccountBalanceResponse.class);
	}
}
