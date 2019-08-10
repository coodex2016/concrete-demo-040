/*
 * Copyright (c) 2019 coodex.org (jujus.shen@126.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.coodex.concrete.demo.impl;

import org.coodex.concrete.demo.api.excepted.MessageTriggerService;
import org.coodex.concrete.message.Queue;
import org.coodex.concrete.message.Topic;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class MessageTriggerServiceImpl implements MessageTriggerService {

    // 定义一个主题，主题由主题类型，消息类型，队列三部分共同确定
    @Inject
    @Queue("demo")
    private Topic<String> topic;

    @Override
    public void trigger(String x) {
        topic.publish(x);// 使用这个主题发布一个消息
    }
}
