node{
    try{ 
    stage 'Test'
        echo 'test'
    stage 'check out'
        git url:'https://github.com/Shiva243/FIM.git'
        echo 'Successfully checkout'
    stage 'Build project'
    //dir('FIM'){
        sh 'gradle clean build'
        echo 'build successfully'
        stage 'deploy'
            sh 'cf login -a https://api.run.pivotal.io -u svelagandula@nisum.com -p Neethu@243'
            sh 'cf push FIMTEST'
            echo 'Deployed successfully'
        stage 'Mail'
            notifyBuild('Build Success')
        
    //}
    }catch(Exception e){
        echo 'Failed'
        notifyBuild('Build Failed, Please check and fix ASAP.')
    }
          
}
def notifyBuild(String buildStatus){
    echo "build status '${buildStatus}'"
    mail  subject: "${buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' ", 
        bcc: '', body: "${buildStatus} \n Job Details <table>
    <tr>
        <th>Job Name</th>
        <th>Build Number</th>
        <th>Build Url</th>
    </tr>
    </table>
    ${env.JOB_NAME} [${env.BUILD_NUMBER}] (${env.BUILD_URL})'", 
        cc: '', from: '', replyTo: '',
        to: 'shivav809@gmail.com'
}
