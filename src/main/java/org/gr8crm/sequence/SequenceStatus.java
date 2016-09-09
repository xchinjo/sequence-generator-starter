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

/**
 * A sequence generator snapshot.
 */
public class SequenceStatus {

    private final String name;
    private String group;
    private final String format;
    private final long number;
    private final int increment;

    public SequenceStatus(String name, String group, String format, long number, int increment) {
        this.name = name;
        this.group = group;
        this.format = format;
        this.number = number;
        this.increment = increment;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public String getFormat() {
        return format;
    }

    public long getNumber() {
        return number;
    }

    public int getIncrement() {
        return increment;
    }

    String getNumberFormatted() {
        return String.format(format, number);
    }

    @Override
    public String toString() {
        return name + "=" + getNumberFormatted();
    }
}