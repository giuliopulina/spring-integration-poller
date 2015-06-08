This is a sample project created while performing an analysis of an issue regarding spring integration configuration.

The issue was that, introducing in the project a new jdbc poller with a fixed-rate of 1 second, the poller was (wrongly) executed every 60 seconds.

With the precious help of Gary Russell, after some tries I found the issue, that was related to default "taskScheduler" pool-size (that is set to 10).

In fact, I discovered that everything was working fine when the project contained 5 serviceactivators/pollers:

**mvn clean compile && mvn exec:java -Dexec.mainClass="com.giuliopulina.main.MainWith5ServiceActivatorsWorking"**

Instead, with 10 serviceactivators/pollers (plus my new jdbc poller), the rate of the jdbc poller was 60 seconds, even if it was configured at 1 second.

**mvn clean compile && mvn exec:java -Dexec.mainClass="com.giuliopulina.main.MainWith10ServiceActivatorsNotWorking"**

Adding the following line to spring configuration solves to issues (this configuration is not present on this github project):

`<task:scheduler id="taskScheduler" pool-size="15" />`

Master branch contains a version of the project that use spring integration 2.1.0.RELEASE version.
Other branches are related to 3.0.7.RELEASE and 4.1.4.RELEASE versions, but the behaviour is the same for all these versions.

See: http://stackoverflow.com/questions/30477612/spring-integration-poller-triggering-with-the-wrong-time-interval
