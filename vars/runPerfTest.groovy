import groovy.json.*

def call(Map params){
    def testName= params.get("testName")
    def testType= params.getOrDefault("testType", true)
    echo "works"
    echo "hello"


}
