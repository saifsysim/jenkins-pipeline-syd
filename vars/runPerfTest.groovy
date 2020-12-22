import groovy.json.*
import java.util.logging.Logger

def call(Map params){

    //Input Parameters required for Test Execution on PerfOps QA
    def testName= params.get("testName")
    def testType= params.getOrDefault("testType", 'pipeline')
    def userName = params.get("userName")
    def env = params.getOrDefault("env", 'qa')

//    println testName
//    println testType
//    println userName
//    println env

    //Verify Inputs
    assert testName != null:"please provide Test name"
    assert userName != null:"please provide User name"


    //Block to Start Performance Test on PerfOps using PerfOps API's
    def sout = new StringBuilder(), serr = new StringBuilder();
    Logger logger = Logger.getLogger("testName")
    def process = [ 'bash', '-c', "curl -X POST -H \"Content-Type: application/json\"  -H \"Accept: */*\" -H \"Cache-Control: no-cache\" -H \"Postman-Token: f7f691b9-dcf9-6371-2b74-beb8517e3a5a0\" -d '{ \"repeatTest\": \"yes\",\"testName\": \"${testName}\", \"uesrs_userId\": \"${userName}\"}' http://gvez9.mocklab.io/run/runTest" ].execute()
    process.consumeProcessOutput(sout, serr)
    process.waitForOrKill(1000)
    println sout
    def startTestResponse = sout
    println startTestResponse
    echo "UID printed"
    UdId = sout.toString().split(':')[1].replaceAll("\\s","")
    echo UdId

}
