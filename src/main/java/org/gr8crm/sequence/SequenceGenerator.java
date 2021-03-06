/*
 * Copyright (c) 2016 Goran Ehrsson.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gr8crm.sequence;

import java.util.stream.Stream;

/**
 * Interface for sequence generators.
 */
public interface SequenceGenerator {
    /**
     * Create a new sequence.
     *
     * @param configuration configuration to initialize sequence with
     * @return sequence status after initialization
     */
    SequenceStatus create(SequenceConfiguration configuration);

    /**
     * Delete a sequence.
     *
     * @param app    application name
     * @param tenant tenant ID
     * @param name   sequence name
     * @param group  sub-sequence
     * @return true if sequence was removed
     */
    boolean delete(String app, long tenant, String name, String group);

    /**
     * Get next unique number formatted.
     *
     * @param app    application name
     * @param tenant tenant ID
     * @param name   sequence name
     * @param group  sub-sequence
     * @return formatted number
     */
    String nextNumber(String app, long tenant, String name, String group);

    /**
     * Get next unique (raw) number.
     *
     * @param app    application name
     * @param tenant tenant ID
     * @param name   sequence name
     * @param group  sub-sequence
     * @return number as a long
     */
    long nextNumberLong(String app, long tenant, String name, String group);

    /**
     * Update sequence.
     *
     * @param app       application name
     * @param tenant    tenant ID
     * @param name      sequence name
     * @param group     sub-sequence
     * @param current   current number
     * @param start     new number
     * @return sequence status after update
     */
    SequenceStatus update(String app, long tenant, String name, String group, long current, long start);

    /**
     * Current status of a sequence.
     *
     * @param app    application name
     * @param tenant tenant ID
     * @param name   sequence name
     * @param group  sub-sequence
     * @return current status or null if no such sequence exists
     */
    SequenceStatus status(String app, long tenant, String name, String group);

    /**
     * Get sequence statistics.
     *
     * @param app    application name
     * @param tenant tenant ID
     * @return statistics for all sequences in the tenant
     */
    Stream<SequenceStatus> statistics(String app, long tenant);

    /**
     * Shutdown the sequence generator.
     * Implementations can close connections, do cleanup, etc.
     */
    void shutdown();
}
