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

import java.util.Map;

/**
 * The {@code EntityCollection} class represents a collection of entities.
 *
 * @param <T> The type of members in the collection.
 */
public class EntityCollection<T extends Entity> extends ResourceCollection<T> {

    /**
     * Class constructor.
     *
     * @param service The connected {@code Service} instance.
     * @param path The entity's endpoint.
     */
    EntityCollection(Service service, String path) {
        super(service, path, Entity.class);
    }

    /**
     * Class constructor.
     *
     * @param service The connected {@code Service} instance.
     * @param path The entity's endpoint.
     * @param itemClass The entity's subclass.
     */
    public EntityCollection(Service service, String path, Class itemClass) {
        super(service, path, itemClass);
    }

    /**
     * Creates an entity in this collection.
     *
     * @param name The name of the entity.
     * @return The entity.
     */
    public T create(String name) {
        return create(name, null);
    }

    /**
     * Creates an entity in this collection.
     *
     * @param name The name of the entity.
     * @param args The arguments that are provided for creating the entity.
     * @return The entity.
     */
    public T create(String name, Map args) {
        args = Args.create(args).add("name", name);
        service.post(path, args);
        invalidate();
        return get(name);
    }

    /**
     * Removes an entity from this collection.
     *
     * @param key The name of the entity to remove.
     * @return This collection.
     */
    public T remove(Object key) {
        validate();
        if (!containsKey(key)) return null;
        T entity = items.get(key);
        entity.remove();
        items.remove(key);
        invalidate();
        return entity;
    }
}
