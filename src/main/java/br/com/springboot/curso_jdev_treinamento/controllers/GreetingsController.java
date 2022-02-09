package br.com.springboot.curso_jdev_treinamento.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import antlr.collections.List;
import br.com.springboot.curso_jdev_treinamento.model.Usuario;
import br.com.springboot.curso_jdev_treinamento.repository.UsuarioRepository;




@RestController
public class GreetingsController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
 
  
   
    
    @GetMapping(value = "listatodos")
    @ResponseBody
    public ResponseEntity<java.util.List<Usuario>> listaUsuario(){
    	java.util.List<Usuario> usuarios =  usuarioRepository.findAll();
    	   	return new ResponseEntity<java.util.List<Usuario>>(usuarios, HttpStatus.OK);
    
    } 
    @PostMapping(value ="/salvar")
    @ResponseBody
    public ResponseEntity<Usuario> salvar( @RequestBody Usuario usuario ){
    	Usuario user = usuarioRepository.save(usuario);
    	return new ResponseEntity<Usuario>(user, HttpStatus.CREATED);
    }
    
    @DeleteMapping(value ="delete")
    @ResponseBody
    public ResponseEntity<String> delete( @RequestParam Long iduser ){
    	usuarioRepository.deleteById(iduser);
    	return new ResponseEntity<String>("User deletado com sucesso", HttpStatus.OK);
    }
    
    
    
    
    

}