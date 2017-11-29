package com.pokemonaddon.api.resource;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pokemonaddon.api.event.CreatedResourceEvent;
import com.pokemonaddon.api.exceptionhandler.PokemonAddonExceptionHandler.GameError;
import com.pokemonaddon.api.model.Pokemon;
import com.pokemonaddon.api.repository.PokemonRepository;
import com.pokemonaddon.api.repository.filter.PokemonFilter;
import com.pokemonaddon.api.repository.projection.ResumePokemon;
import com.pokemonaddon.api.service.PokemonService;
import com.pokemonaddon.api.service.exception.AbilityDoesNotExistException;
import com.pokemonaddon.api.service.exception.MoveDoesNotExistException;

@RestController
@RequestMapping("/pokemons")
public class PokemonResource {

	@Autowired
	private PokemonRepository pokemonRepository;
	
	@Autowired
	private PokemonService pokemonService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping("/all")
	public List<Pokemon> searchAllPokemons() {
		return pokemonRepository.findAll();
	}
	
	@GetMapping
	public Page<Pokemon> searchWithFilter(PokemonFilter pokemonFilter, Pageable pageable) {
		return pokemonRepository.filter(pokemonFilter, pageable);
	}
	
	@GetMapping(params = "resume")
	public Page<ResumePokemon> resume(PokemonFilter pokemonFilter, Pageable pageable) {
		return pokemonRepository.resume(pokemonFilter, pageable);
	}
	
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_SAVE_POKEMON') and #oauth2.hasScope('write')")
	public ResponseEntity<Pokemon> saveNewPokemon(@Valid @RequestBody Pokemon pokemon, HttpServletResponse response) {
		Pokemon savedPokemon = pokemonService.savePokemon(pokemon);
		
		publisher.publishEvent(new CreatedResourceEvent(this, response, savedPokemon.getPokedexId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(savedPokemon);
	}
	
	@ExceptionHandler({AbilityDoesNotExistException.class})
	public ResponseEntity<Object> handleAbilityDoesNotExistException(AbilityDoesNotExistException ex) {
		String userMessage = messageSource.getMessage("ability.does-not-exist", null, LocaleContextHolder.getLocale());
		String developerMessage = ex.toString();
		List<GameError> errors = Arrays.asList(new GameError(userMessage, developerMessage));
		
		return ResponseEntity.badRequest().body(errors);
	}
	
	@ExceptionHandler({MoveDoesNotExistException.class})
	public ResponseEntity<Object> handleMoveDoesNotExistException(MoveDoesNotExistException ex) {
		String userMessage = messageSource.getMessage("move.does-not-exist", null, LocaleContextHolder.getLocale());
		String developerMessage = ex.toString();
		List<GameError> errors = Arrays.asList(new GameError(userMessage, developerMessage));
		
		return ResponseEntity.badRequest().body(errors);
	}
}
