/*-
 * ========================LICENSE_START=================================
 * restheart-security
 * %%
 * Copyright (C) 2018 - 2020 SoftInstigate
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * =========================LICENSE_END==================================
 */
package org.restheart.plugins.security;

import io.undertow.security.idm.PasswordCredential;
import java.util.Set;

/**
 * Account implementation that holds PasswordCredential
 *
 * @author Andrea Di Cesare {@literal <andrea@softinstigate.com>}
 */
public class PwdCredentialAccount extends BaseAccount {
    private static final long serialVersionUID = -5840334837968478775L;
    final transient private PasswordCredential credential;

    /**
     *
     * @param name
     * @param password
     * @param roles
     */
    public PwdCredentialAccount(final String name, final char[] password, final Set<String> roles) {
        super(name, roles);

        if (password == null) {
            throw new IllegalArgumentException("argument password cannot be null");
        }

        this.credential = new PasswordCredential(password);
    }

    /**
     *
     * @return
     */
    public PasswordCredential getCredentials() {
        return credential;
    }
}
