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

import org.coodex.concrete.core.signature.SignUtil;
import org.coodex.concrete.demo.api.excepted.DemoSignatureService;
import org.coodex.concrete.demo.pojo.ExamplePojo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Named;

@Named
public class DemoSignatureServiceImpl implements DemoSignatureService {

    private final static Logger log = LoggerFactory.getLogger(DemoSignatureServiceImpl.class);

    @Override
    public void doSomeThing(Integer a, String kkk, ExamplePojo pojo) {
        log.info("client keyId: {}, alg: {}, noise: {}, sign: {}",
                SignUtil.getKeyId(),
                SignUtil.getAlgorithm(),
                SignUtil.getNoise(),
                SignUtil.getSign());
    }
}
