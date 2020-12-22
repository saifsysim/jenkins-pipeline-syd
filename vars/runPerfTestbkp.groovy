
import groovy.json.*
def call(Map params){
    def testName = params.get("testName")
    def testType = params.getOrDefault('testType', Pipeline)
    def userName = params.get("userName")
    echo "taken"
    echo "hello"


    assert testName !=null: "please provide test name"

}
