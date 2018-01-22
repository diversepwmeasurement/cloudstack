/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.cloudstack.engine.datacenter.entity.api;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.cloudstack.engine.service.api.ProvisioningService;
import org.apache.cloudstack.framework.ws.jackson.Url;

/**
 * Describes a zone and operations that can be done in a zone.
 */
@Path("/zone/{zoneid}")
@Produces({"application/json"})
@XmlRootElement(name = "zone")
public interface ZoneEntity extends DataCenterResourceEntity {
    @GET
    @Path("/pods")
    List<PodEntity> listPods();

    @Url(clazz = ProvisioningService.class, method = "getPod", name = "id", type = List.class)
    List<String> listPodIds();
}