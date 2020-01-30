/*
 * Copyright 2013-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.fraud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.EmitterProcessor;

import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
class MessagePoller {

	private static final Logger log = LoggerFactory.getLogger(MessagePoller.class);

	private final EmitterProcessor<String> emitterProcessor;

	MessagePoller(EmitterProcessor<String> emitterProcessor) {
		this.emitterProcessor = emitterProcessor;
	}

	public void poll() {
		log.info("Emitting the message");
		this.emitterProcessor.onNext("{\"id\":\"99\",\"temperature\":\"123.45\"}");
	}
}
