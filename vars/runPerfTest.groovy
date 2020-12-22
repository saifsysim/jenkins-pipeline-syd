import groovy.json.*
import java.util.logging.Logger

def call(Map params){
    def testName= params.get("testName")
    def testType= params.getOrDefault("testType", 'pipeline')
    def userName = params.get("userName")
    def env = params.getOrDefault("env", 'qa')

    println testName
    println testType
    println userName
    println env

    assert testName != null:"please provide Test name"
    assert userName != null:"please provide User name"
    def sout = new StringBuilder(), serr = new StringBuilder();
    Logger logger = Logger.getLogger("testName")
    def process = [ 'bash', '-c', "curl -X POST -H \"Content-Type: application/json\"  -H \"Accept: */*\" -H \"Cache-Control: no-cache\" -H \"Postman-Token: f7f691b9-dcf9-6371-2b74-beb8517e3a5a0\" -d '{ \"repeatTest\": \"yes\",\"testName\": \"${testName}\", \"uesrs_userId\": \"${userName}\"}' http://gvez9.mocklab.io/run/runTest" ].execute()
    println(process)
    process.consumeProcessOutput(sout, serr)
    process.waitForOrKill(1000)
    println sout
    echo "UID printed"
    UdId = sout.toString().split(':')[1].replaceAll("\\s","")
    echo UdId

}
