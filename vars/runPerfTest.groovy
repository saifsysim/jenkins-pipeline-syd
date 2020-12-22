import groovy.json.*

def call(Map params){
    def testName= params.get("testName")
    def testType= params.get("testType", true)
    echo "works"
    echo "hello"
    sh 'echo $testType'
}
