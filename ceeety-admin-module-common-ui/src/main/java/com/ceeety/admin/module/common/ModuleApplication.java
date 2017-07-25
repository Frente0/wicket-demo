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

import org.apache.wicket.protocol.http.WebApplication;

/**
 * 业务模块Web应用基类
 * @author Zhiyi-Bai
 * @date 2017年7月22日
 */
public abstract class ModuleApplication extends WebApplication {

    private String moduleApplicationName;
    
    public String getModuleApplicationName() {
        return moduleApplicationName;
    }

    public void setModuleApplicationName(String moduleApplicationName) {
        this.moduleApplicationName = moduleApplicationName;
    }
}
