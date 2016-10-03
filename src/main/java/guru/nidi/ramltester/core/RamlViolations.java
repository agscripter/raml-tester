/*
 * Copyright (C) 2014 Stefan Niederhauser (nidin@gmx.ch)
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
package guru.nidi.ramltester.core;

import guru.nidi.ramltester.util.Message;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 *
 */
public class RamlViolations implements Iterable<String> {
    private final List<String> violations;
    private final List<Object> violationObjects;

    public RamlViolations() {
        violations = new ArrayList<>();
        violationObjects = new ArrayList<>();
    }

    public void add(Message message) {
        add(message, null);
    }

    public void add(Message message, Object messageObject) {
        violations.add(message.toString());
        violationObjects.add(messageObject);
    }

    void add(String key, Object... params) {
        add(new Message(key, params));
    }

    public void addIf(boolean condition, Message message) {
        if (condition) {
            add(message);
        }
    }

    void addIf(boolean condition, String key, Object... params) {
        addIf(condition, new Message(key, params));
    }

    void addAll(RamlViolations violations) {
        this.violations.addAll(violations.violations);
        this.violationObjects.addAll(violations.violationObjects);
    }

    public int size() {
        return violations.size();
    }

    public boolean isEmpty() {
        return violations.isEmpty();
    }

    public List<String> asList() {
        return Collections.unmodifiableList(violations);
    }

    public List<RamlViolationMessage> asMessages() {
        final List<RamlViolationMessage> res = new ArrayList<>();
        for (int i = 0; i < violations.size(); i++) {
            res.add(new RamlViolationMessage(violations.get(i), violationObjects.get(i)));
        }
        return res;
    }

    @Override
    public Iterator<String> iterator() {
        return violations.iterator();
    }

    @Override
    public String toString() {
        return violations.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final RamlViolations that = (RamlViolations) o;
        return violations.equals(that.violations);

    }

    @Override
    public int hashCode() {
        return violations.hashCode();
    }
}
