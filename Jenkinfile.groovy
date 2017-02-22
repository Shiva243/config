node{
    
    stage 'Test'
        echo 'test'
    stage 'check out'
        git url:'https://github.com/Shiva243/FIM.git'
        echo 'Successfully checkout'
    stage 'Build project'
    dir('FIM'){
        sh 'gradle clean build'
        echo 'build successfully'
        stage 'deploy'
            sh 'cf login -a https://api.run.pivotal.io -u svelagandula@nisum.com -p Neethu@243'
            sh 'cf push FIMTEST'
            sh 'cf bind-service FIMTEST userinfo'
            sh 'cf restart FIMTEST'
            echo 'Deployed successfully'
    }
    
    
            
}
