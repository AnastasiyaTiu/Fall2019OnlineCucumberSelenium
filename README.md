To run test over the Jenkins, specify following top-level maven target as a build part

clean test -Dcucumber.options="--tags @driver"

you can specify any tags that are available in your project 