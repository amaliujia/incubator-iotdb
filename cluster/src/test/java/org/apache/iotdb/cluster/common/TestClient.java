/*
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements.  See the NOTICE file distributed with this work for additional information regarding copyright ownership.  The ASF licenses this file to you under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.  You may obtain a copy of the License at      http://www.apache.org/licenses/LICENSE-2.0  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the License for the specific language governing permissions and limitations under the License.
 */

package org.apache.iotdb.cluster.common;

import java.io.IOException;
import org.apache.iotdb.cluster.rpc.thrift.RaftService.AsyncClient;
import org.apache.thrift.async.TAsyncClientManager;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.TNonblockingSocket;
import org.apache.thrift.transport.TNonblockingTransport;

public class TestClient extends AsyncClient {

  private int serialNum;

  public TestClient() throws IOException {
    super(new TBinaryProtocol.Factory(), new TAsyncClientManager(), new TNonblockingSocket(
        "localhost", 1111));
  }

  TestClient(TProtocolFactory protocolFactory, TAsyncClientManager clientManager,
      TNonblockingTransport transport, int serialNum) {
    super(protocolFactory, clientManager, transport);
    this.serialNum = serialNum;
  }

  public int getSerialNum() {
    return serialNum;
  }

  public void setSerialNum(int serialNum) {
    this.serialNum = serialNum;
  }
}