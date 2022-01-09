package com.example.user.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.entity.Message;

@RestController
public class SendMessageController {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

//	@PostMapping("/produce")
//	public ResponseEntity<String> postModelToKafka(@RequestBody Message msg)
//			throws InterruptedException, ExecutionException {
//		ListenableFuture<SendResult<String, String>> result = kafkaTemplate.send("testtopic", gson.toJson(msg));
//		return new ResponseEntity<>(result.get().getProducerRecord().value(), HttpStatus.OK);
//	}
	@PostMapping("/sendToUser")
	public ResponseEntity<String> sendMessagetoUser(@RequestParam("destination") String destination, @RequestParam("content") String content)
			throws InterruptedException, ExecutionException {
		String username="";
		try {
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (principal instanceof UserDetails) {
			  username = ((UserDetails)principal).getUsername();
			} else {
			  username = principal.toString();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		Message message = new Message(username, destination, content);
		ListenableFuture<SendResult<String, String>> result = kafkaTemplate.send("userChat", message.toString());
		return new ResponseEntity<>(result.get().getProducerRecord().value(), HttpStatus.OK);
	}
	
	
	@PostMapping("/sendToAdmin")
	public ResponseEntity<String> sendMessagetoAdmin(@RequestParam("destination") String destination, @RequestParam("content") String content)
			throws InterruptedException, ExecutionException {
		String username="";
		try {
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (principal instanceof UserDetails) {
			  username = ((UserDetails)principal).getUsername();
			} else {
			  username = principal.toString();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		Message message = new Message(username, destination, content);
		ListenableFuture<SendResult<String, String>> result = kafkaTemplate.send("adminChat", message.toString());
		return new ResponseEntity<>(result.get().getProducerRecord().value(), HttpStatus.OK);
	}
}