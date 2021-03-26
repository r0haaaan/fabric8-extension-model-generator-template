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

import io.fabric8.kubernetes.client.ExtensionAdapterSupport;
import io.fabric8.kubernetes.client.Client;
import io.fabric8.kubernetes.client.ExtensionAdapter;
import okhttp3.OkHttpClient;

import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class __NAME__ExtensionAdapter extends ExtensionAdapterSupport implements ExtensionAdapter<__NAME__Client> {

    static final ConcurrentMap<URL, Boolean> IS_TEKTON = new ConcurrentHashMap<>();
    static final ConcurrentMap<URL, Boolean> USES_TEKTON_APIGROUPS = new ConcurrentHashMap<>();
    
	@Override
	public Class<__NAME__Client> getExtensionType() {
		return __NAME__Client.class;
	}

	@Override
	public Boolean isAdaptable(Client client) {
		return isAdaptable(client, IS_TEKTON, USES_TEKTON_APIGROUPS, "knative.dev");
	}

	@Override
	public __NAME__Client adapt(Client client) {
            return new Default__NAME__Client(client.adapt(OkHttpClient.class), client.getConfiguration());
	}
}
