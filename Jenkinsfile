pipeline{
  agent any
 environment { 
        CC = 'clang'
    }
    stages {
      stage('checkout'){
        steps{
        checkout scm: [$class: 'GitSCM', branches: [[name: '*/master']], 
                       userRemoteConfigs: [[url: 'https://github.com/Shiva243/FIM.git']]]
        }
      }
        stage('Build') {
            steps {
              gradle( 'gradle  build')
 
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
