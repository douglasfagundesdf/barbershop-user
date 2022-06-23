package br.com.barbearia.usuario.api;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.barbearia.usuario.api.dto.ResponseIdDto;
import br.com.barbearia.usuario.api.dto.UserDto;
import br.com.barbearia.usuario.api.dto.UserIncomingDto;
import br.com.barbearia.usuario.service.UserService;

@RestController
@RequestMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> findById(@PathVariable("id") Long id) {
		Optional<UserDto> user = service.findById(id);
		
		return user
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseIdDto<Long>> create(@Valid @RequestBody UserIncomingDto userIncomingDto) {
		Long id = service.create(userIncomingDto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseIdDto<>(id));
	}
	
}
