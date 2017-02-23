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
     // mailtable()    
}
def notifyBuild(String buildStatus){
    def writer = new StringWriter()  // html is written here by markup builder
def markup = new groovy.xml.MarkupBuilder(writer) 
    echo "build status '${buildStatus}'"
    mail  subject: "${buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' ", 
        bcc: '', body: "${buildStatus} \n Job Details '${env.JOB_NAME} [${env.BUILD_NUMBER}] (${env.BUILD_URL})'", 
        cc: '', from: '', replyTo: '',
        to: 'shivav809@gmail.com'
}
def mailtable(){
    def writer = new StringWriter()  // html is written here by markup builder
def markup = new groovy.xml.MarkupBuilder(writer)  // the builder
 
markup.html{
    table {
        tr {
            td(class:"row", "hello world!")  
        }
    }
}
 
println writer.toString();
}
