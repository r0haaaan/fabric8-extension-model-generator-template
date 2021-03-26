/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.fabric8.__NAME_IN_IMPORT__.client;

import io.fabric8.kubernetes.client.BaseClient;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.RequestConfig;
import io.fabric8.kubernetes.client.WithRequestCallable;
import io.fabric8.kubernetes.client.dsl.FunctionCallable;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import okhttp3.OkHttpClient;

public class Default__NAME__Client extends BaseClient implements Namespaced__NAME__Client {

    public Default__NAME__Client() {
        super();
    }

    public Default__NAME__Client(Config configuration) {
        super(configuration);
    }

    public Default__NAME__Client(OkHttpClient httpClient, Config configuration) {
        super(httpClient, configuration);
    }

    @Override
    public Namespaced__NAME__Client inAnyNamespace() {
        return inNamespace(null);
    }

    @Override
    public Namespaced__NAME__Client inNamespace(String namespace) {
        Config updated = new ConfigBuilder(getConfiguration()).withNamespace(namespace).build();

        return new Default__NAME__Client(getHttpClient(), updated);
    }

    @Override
    public FunctionCallable<Namespaced__NAME__Client> withRequestConfig(RequestConfig requestConfig) {
        return new WithRequestCallable<Namespaced__NAME__Client>(this, requestConfig);
    }

    __CLIENT_RESOURCE_METHODS__
}
