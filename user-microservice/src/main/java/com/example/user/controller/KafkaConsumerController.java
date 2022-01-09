package com.example.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;

@RestController
public class KafkaConsumerController {
	
	private String userChatMsg;
	private String adminChatMsg;
	
	@Autowired
	KafkaConsumerController() {
	    this.userChatMsg = "";
	    this.adminChatMsg = "";
	}

	@KafkaListener(id = "thing1", topicPartitions =
        { @TopicPartition(topic = "adminChat",partitions = { "0", "1" },partitionOffsets = @PartitionOffset(partition = "*", initialOffset = "0"))
        })
	public void getAdminMessage(@RequestBody String emp) {
		System.out.println("Admin chat: " + emp);
		this.adminChatMsg+=emp+"\n";
	}
	
	
	@KafkaListener(id = "thing2", topicPartitions =
        { @TopicPartition(topic = "userChat",partitions = { "0", "1" },partitionOffsets = @PartitionOffset(partition = "*", initialOffset = "0"))
        })
	public void getUserMessage(@RequestBody String emp) {
		System.out.println("User Chat: " + emp);
		this.userChatMsg+=emp+"\n";
	}
	
	@GetMapping("/readUserChat")
	public String readUserMessage(){
		return this.userChatMsg;
	}
	
	@GetMapping("/readAdminChat")
	public String readAdminMessage(){
		return this.adminChatMsg;
	}
}