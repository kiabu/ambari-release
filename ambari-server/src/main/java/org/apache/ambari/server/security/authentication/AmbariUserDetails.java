/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.ambari.server.security.authentication;

import java.util.Collection;

import org.apache.ambari.server.security.authorization.AmbariGrantedAuthority;
import org.apache.ambari.server.security.authorization.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class AmbariUserDetails implements UserDetails {
  private final User user;
  private final Collection<AmbariGrantedAuthority> userAuthorities;

  public AmbariUserDetails(User user, Collection<AmbariGrantedAuthority> userAuthorities) {
    this.user = user;
    this.userAuthorities = userAuthorities;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return userAuthorities;
  }

  @Override
  public String getPassword() {
    return (user == null) ? null : "";
  }

  @Override
  public String getUsername() {
    return (user == null) ? null : user.getUserName();
  }

  public Integer getUserId() {
    return (user == null) ? null : user.getUserId();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
