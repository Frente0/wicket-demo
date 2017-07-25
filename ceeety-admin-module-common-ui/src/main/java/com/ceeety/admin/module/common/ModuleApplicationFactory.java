/**
 * Copyright OPS4J
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ceeety.admin.module.common;

import org.ops4j.pax.wicket.api.WebApplicationFactory;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.service.blueprint.container.BlueprintContainer;

public abstract class ModuleApplicationFactory<C extends ModuleApplication> implements WebApplicationFactory<C> {
    
    private static final String MODULE_APP_PREFIX = "此时此地-管理平台-业务模块-";
    
    private Bundle bundle;  
    private BundleContext bundleContext;  
    private BlueprintContainer blueprintContainer;
    private String applicationName;
    
    public void onInstantiation(ModuleApplication application) {
        application.setModuleApplicationName(MODULE_APP_PREFIX + applicationName);
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public Bundle getBundle() {
        return bundle;
    }

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }

    public BundleContext getBundleContext() {
        return bundleContext;
    }

    public void setBundleContext(BundleContext bundleContext) {
        this.bundleContext = bundleContext;
    }

    public BlueprintContainer getBlueprintContainer() {
        return blueprintContainer;
    }

    public void setBlueprintContainer(BlueprintContainer blueprintContainer) {
        this.blueprintContainer = blueprintContainer;
    }
}
