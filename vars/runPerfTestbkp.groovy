

def call(Map params){
    def testName = params.get("testName")
    def testType = params.getOrDefault('testType', Pipeline)
    def userName = params.get("userName")
    echo "works"
    echo "hello"


    assert testName !=null: "please provide test name"

}
