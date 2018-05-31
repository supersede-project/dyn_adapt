#Configure adapter
sed -i 's/demo=true/demo=false/g' ./src/main/resources/adapter.properties
#stop adapter
./shutdownAdapter.sh
#start adapter
./startAdapterProduction.sh
