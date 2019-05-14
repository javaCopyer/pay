package com.minghui.pay.agent.core.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("deploy.properties")
@ConfigurationProperties(prefix="deploy.auth.token")
public class DeployAuthToken {
	private String expires;

	public String getExpires() {
		return expires;
	}

	public void setExpires(String expires) {
		this.expires = expires;
	}
	
}
