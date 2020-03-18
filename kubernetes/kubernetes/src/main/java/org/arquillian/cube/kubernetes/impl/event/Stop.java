/**
 * Copyright 2005-2016 Red Hat, Inc.
 * <p>
 * Red Hat licenses this file to you under the Apache License, version
 * 2.0 (the "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.  See the License for the specific language governing
 * permissions and limitations under the License.
 */
package org.arquillian.cube.kubernetes.impl.event;

import org.arquillian.cube.kubernetes.impl.DefaultSession;
import org.arquillian.cube.kubernetes.impl.SessionCreatedEvent;

public class Stop extends SessionCreatedEvent {

    public Stop(DefaultSession session) {
        super(session);
    }
}
