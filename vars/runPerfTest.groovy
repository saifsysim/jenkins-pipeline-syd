import groovy.json.*
import java.util.logging.Logger

def call(Map params){
    def testName= params.get("testName")
    def testType= params.getOrDefault("testType", true)
    echo "works"
    echo "hello"
    println testName


}
