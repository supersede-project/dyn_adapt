package eu.supersede.dynadapt.enactor.HypervisorEnactor.test;



import eu.supersede.dynadapt.enactor.HypervisorEnactor.HypervisorEnactor;

public class RestoreSmartHSKVirtualConfiguration {
	
	public static void main (String[] args) throws Exception{
		restoreSmartHSKVirtualConfiguration (args[0], args[1]);
	}
	
	public static void restoreSmartHSKVirtualConfiguration (String serverPassword, String hypervisorPassword) throws Exception{		
		HypervisorEnactor enactor = new HypervisorEnactor();
		System.out.println(enactor.injectPowerShellScript ("./src/RestoreSmartHSKVirtualConfiguration.ps1", serverPassword, hypervisorPassword));
		System.out.println(enactor.executePowerShellScript ("RestoreSmartHSKVirtualConfiguration.ps1", serverPassword, hypervisorPassword));		
	}
}
