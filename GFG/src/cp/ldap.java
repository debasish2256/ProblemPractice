package com.highradius.cp;

import java.util.Hashtable;
import java.util.Properties;

import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.*;

import com.highradius.core.utils.MaskUtils;

public class ldap {
	DirContext connection;
	private void bindUser(Hashtable<String,String> env, String password, String userDn) {
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		env.put(Context.SECURITY_CREDENTIALS, password);
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.SECURITY_PRINCIPAL, userDn);
		env.put(Context.PROVIDER_URL, "https://hoogle.highradius.com/");
		//env.put(Context.PROVIDER_URL, "ldap://ldap1.in.highradius.com");
	}
	
	private DirContext authenticate(Hashtable<String,String> env) throws NamingException {
		DirContext ctx = new InitialDirContext(env);
		return ctx;
	}
	
	public boolean login(String username, String password) {
		boolean isValidLogin = false;
		boolean userExists  = false;
		try {
			String userDn = "uid="+username+",ou=People,dc=highradius,dc=com";
			Hashtable<String,String> userEnv = new Hashtable<String, String>();
			bindUser(userEnv, password, userDn);
			DirContext userCtx = authenticate(userEnv);
			if(userCtx != null) {
				isValidLogin= true;
				String maskedUserName=MaskUtils.toMaskedUserName(username, 2, 2);
			}
		} catch (NamingException e1) {
			String maskedUserName=MaskUtils.toMaskedUserName(username, 2, 2);
			return isValidLogin;
		}
		return isValidLogin;
	}
	
	
	
	public static void main(String[] args) throws NamingException {

		 ldap app = new ldap();
		 System.out.println(app.login("debasish.mahana","Apr@2021"));
		  
	}
}
