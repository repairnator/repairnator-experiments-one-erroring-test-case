/*
 Licensed to the Apache Software Foundation (ASF) under one
 or more contributor license agreements.  See the NOTICE file
 distributed with this work for additional information
 regarding copyright ownership.  The ASF licenses this file
 to you under the Apache License, Version 2.0 (the
 "License"); you may not use this file except in compliance
 with the License.  You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing,
 software distributed under the License is distributed on an
 "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 KIND, either express or implied.  See the License for the
 specific language governing permissions and limitations
 under the License.
 */
package org.apache.plc4x.java.ads.api.serial.types;

import io.netty.buffer.ByteBuf;
import org.apache.plc4x.java.ads.api.util.ByteValue;

public class TransmitterAddress extends ByteValue {

    public static final int NUM_BYTES = 1;

    public static final TransmitterAddress RS232_COMM_ADDRESS = TransmitterAddress.of((byte) 0);

    private TransmitterAddress(byte value) {
        super(value);
    }

    private TransmitterAddress(ByteBuf byteBuf) {
        this(byteBuf.readByte());
    }

    public static TransmitterAddress of(byte value) {
        return new TransmitterAddress(value);
    }

    public static TransmitterAddress of(ByteBuf byteBuf) {
        return new TransmitterAddress(byteBuf);
    }

}
