#Configure adapter
sed -i 's/demo=true/demo=false/g' ./src/main/resources/adapter.properties
#stop adapter
./shutdownAdapterDevelopment.sh
#start adapter
./startAdapterDevelopment.sh
