To run test over the Jenkins, specify following top-level maven target as a build part

clean test -Dcucumber.options="--tags @driver"

you can specify any tags that are available in your project

To run smoke test use:

clean test -P Smoke

To start regression execute:

clean test -P Regression

To run feature files in parallel without limiting number of threads:

   <parallel>methods</parallel>
   <useUnlimitedThreads>true</useUnlimitedThreads>
   <includes>
     <include>**/RegressionRunner*.java</include>
   </includes> 
   
   To specify browser type, use parameter -Dbrowser=browserType:
   
   clean test -Dbrowser=firefox -Denv=qa3 -P Regression