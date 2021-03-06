//******************************************************************************
//Copyright (c) 2012 IBM Corp.
//
//Licensed under the Apache License, Version 2.0 (the "License");
//you may not use this file except in compliance with the License.
//You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
//Unless required by applicable law or agreed to in writing, software
//distributed under the License is distributed on an "AS IS" BASIS,
//WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//See the License for the specific language governing permissions and
//limitations under the License.
//******************************************************************************

import java.util.HashMap;
import api.APIServiceClient;
import api.APIException;
import api.APINoSuchDataException;

public class ProvisionVM {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws APINoSuchDataException {
		 try {
			 APIServiceClient api = new APIServiceClient("172.16.1.250", 7080);
			 
			 // Create a VM
			 HashMap<String, String> vm = (HashMap<String, String>) api.perform("vmattach", "TESTSIMCLOUD", "tinyvm");
			 
			 System.out.println("Created VM: " + vm.get("uuid"));
			 
			 // Lookup some data from the monitoring system
			 //System.out.println(api.get_latest_data("TESTSIMCLOUD", vm.get("uuid"), "runtime_os_VM"));
			 
    		 for(String key : vm.keySet()) {
    			 System.out.println(key + " = " + String.valueOf(vm.get(key)));
    		 }
    		 
    		 // Destroy the VM
    		 // System.out.println("Destroying VM...");
    		 // api.perform("vmdetach",  "TESTSIMCLOUD", vm.get("uuid"));
    		 
		 } catch (APIException e) {
		     System.err.println("APIServiceClient failure: " + e);
		 }
	}

}
