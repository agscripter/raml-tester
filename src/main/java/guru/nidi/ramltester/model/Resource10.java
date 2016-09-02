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
package guru.nidi.ramltester.model;

import org.raml.v2.api.model.v10.resources.Resource;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;

/**
 *
 */
public class Resource10 implements UnifiedResource {
    private Resource resource;

    public Resource10(Resource resource) {
        this.resource = resource;
    }

    static List<UnifiedResource> of(List<Resource> resources) {
        final List<UnifiedResource> res = new ArrayList<>();
        for (final Resource r : resources) {
            res.add(new Resource10(r));
        }
        return res;
    }

    @Override
    public String description() {
        return resource.description() == null ? null : resource.description().value();
    }

    @Override
    public String displayName() {
        return resource.displayName().value();
    }

    @Override
    public String relativeUri() {
        return resource.relativeUri().value();
    }

    @Override
    public List<UnifiedResource> resources() {
        return of(resource.resources());
    }

    @Override
    public String resourcePath() {
        return resource.resourcePath();
    }

    @Override
    public UnifiedResource parentResource() {
        return resource.parentResource() == null ? null : new Resource10(resource.parentResource());
    }

    @Override
    public List<UnifiedMethod> methods() {
        return Method10.of(resource.methods());
    }

    @Override
    public List<UnifiedType> uriParameters() {
        return Type10.of(resource.uriParameters());
    }

    @Override
    public List<UnifiedType> baseUriParameters() {
        return emptyList();
    }

    @Override
    public List<UnifiedSecSchemeRef> securedBy() {
        return SecSchemeRef10.of(resource.securedBy());
    }
}
