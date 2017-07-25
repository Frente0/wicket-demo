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
package com.ceeety.admin.module.device;

import org.apache.wicket.protocol.http.WebApplication;

import com.ceeety.admin.module.common.ModuleApplication;
import com.ceeety.admin.module.device.action.DeleteAction;
import com.ceeety.admin.module.device.action.PageAction;
import com.ceeety.admin.module.device.service.DeviceLocationService;
import com.ceeety.admin.module.device.service.DeviceService;
import com.ceeety.admin.module.device.service.DeviceTypeService;
import com.ceeety.admin.module.device.service.GroupService;
import com.ceeety.admin.module.device.service.RelationService;
import com.ceeety.admin.module.device.ui.AddPage;
import com.ceeety.admin.module.device.ui.EditPage;
import com.ceeety.admin.module.device.ui.HomePage;
import com.ceeety.admin.module.device.ui.ListPage;

/**
 * 设备管理应用
 * @author Zhiyi-Bai
 * @date 2017年7月22日
 */
public class Application extends ModuleApplication {
    
    private DeviceService deviceService;
    private DeviceTypeService deviceTypeService;
    private DeviceLocationService deviceLocationService;
    private GroupService groupService;
    private RelationService relationService;

    public Application() {
        super();
    }
    

    @Override
    public Class<HomePage> getHomePage() {
        return HomePage.class;
    }
    
    @Override
    protected void init() {
        super.init();
        //列表页
        mountPage("/list", ListPage.class);
        //AJAX分页获取数据
        mountPage("/list/page", PageAction.class);
        //新建页面
        mountPage("/add", AddPage.class);
        //编辑页面
        mountPage("/edit/${id}", EditPage.class);
        //编辑页面
        mountPage("/delete/${id}", DeleteAction.class);
    }

    public static Application get() {
        return (Application) WebApplication.get();
    }

    public DeviceService getDeviceService() {
        return deviceService;
    }

    public void setDeviceService(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    public DeviceTypeService getDeviceTypeService() {
        return deviceTypeService;
    }

    public void setDeviceTypeService(DeviceTypeService deviceTypeService) {
        this.deviceTypeService = deviceTypeService;
    }

    public DeviceLocationService getDeviceLocationService() {
        return deviceLocationService;
    }

    public void setDeviceLocationService(DeviceLocationService deviceLocationService) {
        this.deviceLocationService = deviceLocationService;
    }

    public GroupService getGroupService() {
        return groupService;
    }

    public void setGroupService(GroupService groupService) {
        this.groupService = groupService;
    }

    public RelationService getRelationService() {
        return relationService;
    }

    public void setRelationService(RelationService relationService) {
        this.relationService = relationService;
    }
    
    
}
