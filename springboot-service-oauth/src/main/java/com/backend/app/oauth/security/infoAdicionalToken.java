package com.backend.app.oauth.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.backend.app.commons.users.entity.Usuario;
import com.backend.app.oauth.service.UsuarioService;

@Component
public class infoAdicionalToken implements TokenEnhancer{

	@Autowired
	private UsuarioService service;
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Map<String, Object> info = new HashMap<>();
		
		Usuario user = service.findByUsername(authentication.getName());
		
		info.put("nombre", user.getNombre());
		info.put("appellido", user.getApellido());
		info.put("correo", user.getEmail());
		info.put("ClaimPrueba", "Valor de prueba");
		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		
		return accessToken;
	}
}
