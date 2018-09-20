time mvn -f pom_pit.xml org.pitest:pitest-maven:mutationCoverage > `date '+%Y%m%d%H%M'`_pit.log

#This will output an html report to target/pit-reports/<YYYYMMDDHHMI>.
