pipeline{
  agent any
 environment { 
        CC = 'clang'
    }
    stages {
      stage('checkout'){
        checkout scm: [$class: 'GitSCM', branches: [[name: '*/master']], 
                       userRemoteConfigs: [[url: 'https://github.com/Shiva243/FIM.git']]]
      }
        stage('Build') {
            steps {
              gradle : ['gradle clean build']
                echo 'Building..'
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
