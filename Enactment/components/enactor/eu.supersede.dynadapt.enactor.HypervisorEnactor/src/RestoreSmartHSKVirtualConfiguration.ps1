# To execute script in command line invoke:
# Powershell -File RestoreSmartHSKVirtualConfiguration.ps1 -password <password>

#Connect with Atos Smart Hypervisor
#Password is taken from command line upon invocation
Connect-VIServer -Server medialab13.atosresearch.eu -User root -Password $password

#Stoping vm with name: OVP BO
Stop-VM -VM "OVP BO" -Confirm:$false

#Setting vm cores to 2
Get-VM "OVP BO" | Set-VM -NumCpu 2 -Confirm:$false

#Setting vm memory to 2.0
Get-VM "OVP BO" | Set-VM -MemoryGB 2.0 -Confirm:$false

#Starting vm with name: OVP BO
Start-VM -VM "OVP BO" -Confirm:$false
