package com.catgpt.catgpt.repositories;

import com.catgpt.catgpt.models.chat_data;
import org.springframework.data.repository.CrudRepository;

public interface ChatRepository extends CrudRepository<chat_data, Long> {
}
