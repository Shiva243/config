node{
    
    stage 'Test'
        echo 'test'
    stage 'check out'
        git url:'https://github.com/Shiva243/config.git'
        echo 'Successfully checkout'
    stage 'Build project'
        sh 'gradle clean build'
        echo 'build successfully'
    
            
}
