/*
 * Copyright 2012 Splunk, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"): you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.splunk;

/**
 * The {@code WindowsPerfmonInput} class represents a Windows Performance Monitor 
 * (Perfmon) input.
 */
public class WindowsPerfmonInput extends Input {

    /**
     * Class constructor.
     *
     * @param service The connected {@code Service} instance.
     * @param path The Windows Perfmon input endpoint.
     */
    WindowsPerfmonInput(Service service, String path) {
        super(service, path);
    }

    /**
     * Returns a list of monitored counters for this Windows Perfmon input. A "*" 
     * is equivalent to all counters.
     *
     * @return A comma-separated list of counters, or {@code null} if not specified.
     */
    public String getCounters() {
        return getString("counters", null);
    }

    /**
     * Returns the index name of this Windows Perfmon input.
     *
     * @return The index name, or {@code null} if not specified.
     */
    public String getIndex() {
        return getString("index", null);
    }

    /**
     * Returns the counter instances of this Windows Perfmon input. A "*" 
     * is equivalent to all instances.
     *
     * @return The counter instances, or {@code null} if not specified.
     */
    public String getInstances() {
        return getString("instances", null);
    }

    /**
     * Returns the interval at which to poll the performance counters for this
     * Windows Perfmon input.
     *
     * @return The polling interval, in seconds.
     */
    public int getInterval() {
        return getInteger("interval");
    }

    /**
     * Returns the input type of this Windows Perfmon input.
     * @see InputKind
     *
     * @return The input kind.
     */
    public InputKind getKind() {
        return InputKind.WindowsPerfmon;
    }

    /**
     * Returns the performance monitior object for this Windows Perfmon input
     * (for example, "Process", "Server", or "PhysicalDisk".)
     *
     * @return The Windows performance object.
     */
    public String getObject() {
        return getString("object");
    }
}
