def call(Map stageParams){
checkout([
        $class: 'GitSCM',
        branches: [[name: '*/main']],
        doGenerateSubmoduleConfigurations: false,
        extensions: [],
        submoduleCfg: [],
        userRemoteConfigs: [[url: 'https://github.com/saifsysim/jenkins-pipeline-syd.git']]
])
}


