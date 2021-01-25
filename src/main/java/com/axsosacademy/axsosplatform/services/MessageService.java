package com.axsosacademy.axsosplatform.services;

import com.axsosacademy.axsosplatform.models.Message;
import com.axsosacademy.axsosplatform.repositories.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    private final MessageRepository messageRepository;


    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    // create a massege
    public Message createMessage(Message myMessage) {
        return messageRepository.save(myMessage);
    }

    // get all Message and return as a List<Message>
    public List<Message> getAll() {
        return (List<Message>) messageRepository.findAll();
    }


    // find a Message by id
    public Message findMessage(Long id) {
        Optional<Message> mymessage = messageRepository.findById(id);
        if (mymessage.isPresent()) {
            return mymessage.get();
        } else {
            System.out.println("no message you are looking for");
            return null;
        }
    }
}

