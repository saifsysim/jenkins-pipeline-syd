import groovy.json.*

def call(Map params){
    def testName= params.get("testName", PerfOps-TestName)
    echo "works"
    echo "hello"
}
