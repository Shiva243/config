node{
    try{ 
    stage 'Test'
        echo 'test'
    stage 'check out'
        git url:'https://github.com/Shiva243/FIM.git'
        echo 'Successfully checkout'
    stage 'Build project'
    dir('FIM'){
        sh 'gradle clean build'
        echo 'build successfully'
        currentBuild.result='build successfully'
        currentBuild.result
        stage 'deploy'
            sh 'cf login -a https://api.run.pivotal.io -u svelagandula@nisum.com -p Neethu@243'
            sh 'cf push FIMTEST'
            echo "result '${currentBuild.result}'"
            echo 'Deployed successfully'
    }
    }catch(Exception e){
        echo 'Failed'
    }
           
}
