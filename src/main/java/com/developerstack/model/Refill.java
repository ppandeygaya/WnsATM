package com.developerstack.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.SessionAttributes;


@Component
//@Scope(value = "session",  proxyMode = ScopedProxyMode.TARGET_CLASS)
@Scope(value="session")
public class Refill {

    private int money;

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	
    
}
