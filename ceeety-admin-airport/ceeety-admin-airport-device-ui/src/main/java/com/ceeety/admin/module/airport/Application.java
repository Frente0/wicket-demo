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
package com.ceeety.admin.module.airport;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

import com.ceeety.admin.airport.device.service.AirportService;
import com.ceeety.admin.module.airport.ui.HomePage;
import com.ceeety.admin.module.common.ModuleApplication;


/**
 * 
 * @author Qiao-Zhang
 * @Date
 */
public class Application extends ModuleApplication {
    
    private AirportService airportService;


    public Application() {
        super();
    }

    @Override
    public Class<HomePage> getHomePage() {
        return HomePage.class;
    }
    
    public AirportService getAirportService() {
		return airportService;
	}


	public void setAirportService(AirportService airportService) {
		this.airportService = airportService;
	}


	@Override
    protected void init() {
        super.init();
//        //列表页
//        mountPage("/list", ListPage.class);
//        //AJAX分页获取数据
//        mountPage("/list/page", PageAction.class);
//        //新建页面
//        mountPage("/add", AddPage.class);
//        //编辑页面
//        mountPage("/edit/${id}", EditPage.class);
//        //编辑页面
//        mountPage("/delete/${id}", DeleteAction.class);
    }

    public static Application get() {
        return (Application) WebApplication.get();
    }



    
    
}
