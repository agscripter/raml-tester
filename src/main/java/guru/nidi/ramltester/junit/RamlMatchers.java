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
package guru.nidi.ramltester.junit;

import guru.nidi.ramltester.core.RamlReport;
import org.hamcrest.Matcher;

/**
 *
 */
public class RamlMatchers {
    private RamlMatchers() {
    }

    /**
     * RamlReport has correct RAML, and Request/Response.
     *
     * @return
     */
    public static Matcher<RamlReport> hasNoViolations() {
        return new NoViolationsMatcher(true, true, true);
    }

    /**
     * RamlReport has correct RAML.
     *
     * @return
     */
    public static Matcher<RamlReport> validates() {
        return new NoViolationsMatcher(true, false, false);
    }

    /**
     * RamlReport has correct Request/Response.
     *
     * @return
     */
    public static Matcher<RamlReport> checks() {
        return new NoViolationsMatcher(false, true, true);
    }

    /**
     * RamlReport has correct Request.
     *
     * @return
     */
    public static Matcher<RamlReport> requestChecks() {
        return new NoViolationsMatcher(false, true, false);
    }

    /**
     * RamlReport has correct Response.
     *
     * @return
     */
    public static Matcher<RamlReport> responseChecks() {
        return new NoViolationsMatcher(false, false, true);
    }
}
