import java.time.Duration;
import java.time.Instant;
import java.util.Optional;

import javax.print.DocFlavor.URL;

public class LoginResult {

	private final Instant loginTs;

	private final String authToken;
	private final Duration tokenValidity;

	private final URL tokenRefreshUrl;

	// constructor taking every field and checking nulls
	/*
	 * public LoginResult(Instant loginTs, String authToken, Duration tokenValidity,
	 * URL tokenRefreshUrl) { super(); if (loginTs != null) this.loginTs = loginTs;
	 * else throw new NullPointerException("loginTs should not be null");
	 * 
	 * if (authToken != null) this.authToken = authToken; else throw new
	 * NullPointerException("authToken should not be null");
	 * 
	 * if (tokenValidity != null) this.tokenValidity = tokenValidity; else throw new
	 * NullPointerException("tokenValidity should not be null");
	 * 
	 * if (tokenRefreshUrl != null) this.tokenRefreshUrl = tokenRefreshUrl; else
	 * throw new NullPointerException("tokenRefreshUrl should not be null");
	 * 
	 * }
	 */
	public LoginResult(Instant loginTs, String authToken, Duration tokenValidity, URL tokenRefreshUrl) {
		this.loginTs = Optional.ofNullable(loginTs)
				.orElseThrow(() -> new NullPointerException("loginTs should not be null"));
		this.authToken = Optional.ofNullable(authToken)
				.orElseThrow(() -> new IllegalArgumentException("authToken should not be null"));
		this.tokenValidity = Optional.ofNullable(tokenValidity)
				.orElseThrow(() -> new IllegalArgumentException("tokenValidity should not be null"));
		this.tokenRefreshUrl = Optional.ofNullable(tokenRefreshUrl)
				.orElseThrow(() -> new IllegalArgumentException("tokenRefreshUrl should not be null"));

	}

	public Instant getLoginTs() {
		return loginTs;
	}

	public String getAuthToken() {
		return authToken;
	}

	public Duration getTokenValidity() {
		return tokenValidity;
	}

	public URL getTokenRefreshUrl() {
		return tokenRefreshUrl;
	}

}
