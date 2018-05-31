#Configure adapter
sed -i 's/enactment.automatic_processing=false/enactment.automatic_processing=true/g' ./lib/optimizer.properties
#stop adapter
./shutdownDMOptimizer.sh
#start adapter
./startDMOptimizerDevelopment.sh
