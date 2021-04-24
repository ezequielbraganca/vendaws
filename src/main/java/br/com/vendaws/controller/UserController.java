package br.com.vendaws.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vendaws.entity.User;
import br.com.vendaws.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(path = "/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Integer id) {
		try {
			Optional<User> usuario = userService.findById(id);
			return new ResponseEntity<>(usuario, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Exception:" + e, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping
	public ResponseEntity<?> listAll(){
		try {
			return new ResponseEntity<> (userService.findAll(),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<> ("Exception:"+e,HttpStatus.BAD_GATEWAY);
		}
		
	}

	@PostMapping
	public ResponseEntity<?> save( @RequestBody User usuario) {
		try {
			usuario = userService.save(usuario);
			return new ResponseEntity<>(usuario, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("Exception:" + e, HttpStatus.BAD_REQUEST);
		}

	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody User usuario){
		try {
			return new ResponseEntity<>(userService.save(usuario), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>("Exception:" + e, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id){
		try {
			Optional<User> usuario = userService.findById(id);
			userService.delete(usuario.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Exception:" + e, HttpStatus.BAD_REQUEST);
		}
	}

}
