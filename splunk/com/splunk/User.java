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
 * The {@code User} class represents a Splunk user who is registered on the
 * current Splunk server.
 */
public class User extends Entity {

    /**
     * Class constructor.
     *
     * @param service The connected {@code Service} instance.
     * @param path The resource path.
     */
    User(Service service, String path) {
        super(service, path);
    }

    /**
     * Returns the user's default app.
     *
     * @return The default app.
     */
    public String getDefaultApp() {
        return getString("defaultApp", null);
    }

    /**
     * Indicates whether the user's default app was set specifically by the user.
     *
     * @return {@code true} if the default app was set by the user, {@code false} if not.
     */
    public boolean getDefaultAppIsUserOverride() {
        return getBoolean("defaultAppIsUserOverride");
    }

    /**
     * Returns the name of the role that the default app was inherited from, or 
     * {@code system} if it was inherited from the default system setting.
     *
     * @return The name of the role the default app was inherited from, or
     *         {@code system} if it was inherited from the default system
     *         settings.
     */
    public String getDefaultAppSourceRole() {
        return getString("defaultAppSourceRole");
    }

    /**
     * Returns the user's email address.
     *
     * @return The user's email address.
     */
    public String getEmail() {
        return getString("email", null);
    }

    /**
     * Returns the user's password.
     *
     * @return The user's password.
     */
    public String getPassword() {
        return getString("password", null);
    }

    /**
     * Returns the full name associated with this user.
     *
     * @return The user's full name.
     */
    public String getRealName() {
        return getString("realname", null);
    }

    /**
     * Returns an array of roles assigned to this user.
     *
     * @return An array of roles.
     */
    public String[] getRoles() {
        return getStringArray("roles", null);
    }

    /**
     * Returns the authentication method responsible for this user.
     *
     * @return The authentication method for the user.
     */
    public String getType() {
        return getString("type", null);
    }

    /**
     * Returns the time zone to use when displaying dates for this user.
     *
     * @return The user's time zone.
     */
    public String getTz() {
        return getString("tz", null);
    }
}
