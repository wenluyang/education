package com.gaozhao.app_security.anthentication.system;

import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import net.bytebuddy.asm.Advice.This;

public class SysAuthenticationToken extends AbstractAuthenticationToken {

	private final Object principal;
	private Object credentials;

	public SysAuthenticationToken(Object principal, Object credentials) {
		super((Collection) null);
		this.principal = principal;
		this.credentials = credentials;
		this.setAuthenticated(false);
	}

	public SysAuthenticationToken(Object principal, Object credentials,
			Collection<? extends GrantedAuthority> authorities) {
		super(authorities);
		this.principal = principal;
		this.credentials = credentials;
		super.setAuthenticated(true);
	}

	@Override
	public Object getCredentials() {
		return this.credentials;
	}

	@Override
	public Object getPrincipal() {
		return this.principal;
	}

	@Override
	public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
		if (isAuthenticated) {
			throw new IllegalArgumentException(
					"Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
		} else {
			super.setAuthenticated(false);
		}
	}

	@Override
	public void eraseCredentials() {
		super.eraseCredentials();
		this.credentials = null;
	}

}
