package br.com.barbearia.usuario.api.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
}
