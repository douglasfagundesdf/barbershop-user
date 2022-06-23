package br.com.barbearia.usuario.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(updatable = false, nullable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@CreationTimestamp
	private LocalDateTime modifiedAt;
	
	@Column(nullable = false)
	@Version
	private Long version;
	
}
