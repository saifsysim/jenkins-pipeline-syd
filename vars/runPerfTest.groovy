import groovy.json.*
import java.util.logging.Logger

def call(Map params){
    def testName= params.get("testName")
    def testType= params.getOrDefault("testType", pipeline)
    def userName = params.get("userName")
    echo "works"
    echo "hello"
    println testName
    println testType
    println userName


}
