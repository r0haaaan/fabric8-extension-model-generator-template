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
package io.fabric8.__NAME_IN_IMPORT__.mock;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.server.mock.KubernetesMockServer;
import io.fabric8.mockwebserver.Context;
import io.fabric8.mockwebserver.ServerRequest;
import io.fabric8.mockwebserver.ServerResponse;
import io.fabric8.__NAME_IN_IMPORT__.client.Default__NAME__Client;
import io.fabric8.__NAME_IN_IMPORT__.client.__NAME__Client;
import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockWebServer;

import java.util.Map;
import java.util.Queue;

import static io.fabric8.kubernetes.client.utils.HttpClientUtils.createHttpClientForMockServer;
import static okhttp3.TlsVersion.TLS_1_0;

public class __NAME__MockServer extends KubernetesMockServer {
  private boolean disableApiGroupCheck = true;

  public __NAME__MockServer() {
    super();
  }

  public __NAME__MockServer(boolean useHttps) {
    super(useHttps);
  }

  public __NAME__MockServer(Context context, MockWebServer server, Map<ServerRequest, Queue<ServerResponse>> responses, Dispatcher dispatcher, boolean useHttps) {
    super(context, server, responses, dispatcher, useHttps);
  }

  @Override
  public String[] getRootPaths() {
    return new String[]{"/api","/apis/serving.knative.dev", "/apis/eventing/knative.dev"};
  }

  public __NAME__Client create__NAME__() {
    Config config = new ConfigBuilder()
      .withMasterUrl(url("/"))
      .withNamespace("test")
      .withTrustCerts(true)
      .withTlsVersions(TLS_1_0)
      .build();
    return new Default__NAME__Client(createHttpClientForMockServer(config), config);
  }
}
