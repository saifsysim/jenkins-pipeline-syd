import groovy.json.JsonSlurper
import groovy.json.JsonSlurperClassic
def call(String testname, String username, String testtype) {
    try {
        def sout = new StringBuilder(), serr = new StringBuilder()
        def process = [ 'bash', '-c', "curl -X POST -H \"Content-Type: application/json\"  -H \"Accept: */*\" -H \"Cache-Control: no-cache\" -H \"Postman-Token: f7f691b9-dcf9-6371-2b74-beb8517e3a5a0\" -d '{ \"repeatTest\": \"yes\",\"testName\": \"${testname}\", \"uesrs_userId\": \"${username}\"}' http://gvez9.mocklab.io/run/runTest" ].execute()
        process.consumeProcessOutput(sout, serr)
        process.waitForOrKill(1000)
        println sout
        echo "UID printed"

        UdId = sout.toString().split(':')[1].replaceAll("\\s","")
        echo UdId
        String testing = 'STARTED'
//  while(testing == 'STARTED') {  // The followinf lines are commented because this is the check running test status // we can do also in for loop if failed
//      Thread.sleep(30000) //sleeping 30 sec
//      def jsonResponse =  get(UdId)
//      String jsonStatus = getStatus(jsonResponse).runStatus
//      echo jsonStatus
//      testing = jsonStatus
//  }
        echo "starting"
        def status = getFinalStatus(UdId) // getting response of final status
        //println status
        String finalStatus = getStatus(status).runStatus //check run status function
        if (finalStatus == "COMPLETED"){
            echo "Tests Are Done"
            String test_Status =  getStatus(status).testStatus
            echo test_Status
        }
    }catch(Exception e){
        throw e
    }
}
def get(String uid) {
    url = "http://perftest.mocklab.io/run/searchTestbyStatus?executionId="+uid
    def status = new StringBuilder(), serr = new StringBuilder()
    def process = [ 'bash', '-c', "curl -XGET -H 'accept: */*' ${url}" ].execute()
    process.consumeProcessOutput(status, serr)
    process.waitForOrKill(1000)
    return status
}
def getFinalStatus(String uid) {
    url = "http://gvez9.mocklab.io/run/searchTestbyStatusCompleted?executionId="+uid
    def finalstatus = new StringBuilder(), serr = new StringBuilder()
    def finalprocess = [ 'bash', '-c', "curl -XGET -H 'accept: */*' ${url}" ].execute()
    finalprocess.consumeProcessOutput(finalstatus, serr)
    finalprocess.waitForOrKill(5000)
    return finalstatus
}
def getStatus(response){
    def stringReponse = response?.toString()
    //println stringReponse
    def final_status = new JsonSlurperClassic().parseText(stringReponse)
    return final_status[0]
}
def callClosure(a, b) {
    def start = System.currentTimeMillis()
    mem(a, b)
    println "Inputs(a = $a, b = $b) - took ${System.currentTimeMillis() - start} msecs."
}


println "hellllloooi"
hell()
def hell(u){
    println "test"
}