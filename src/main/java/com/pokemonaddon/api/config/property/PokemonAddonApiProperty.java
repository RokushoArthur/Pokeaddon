package com.pokemonaddon.api.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("pokemonaddon")
public class PokemonAddonApiProperty {

	private String permittedOrigin = "http://localhost:8000";
	
	public String getPermittedOrigin() {
		return permittedOrigin;
	}

	public void setPermittedOrigin(String permittedOrigin) {
		this.permittedOrigin = permittedOrigin;
	}

	private final Security security = new Security();
	
	public Security getSecurity() {
		return security;
	}

	public static class Security {
		
		private boolean enableHttps;

		public boolean isEnableHttps() {
			return enableHttps;
		}

		public void setEnableHttps(boolean enableHttps) {
			this.enableHttps = enableHttps;
		}
		
	}
}
