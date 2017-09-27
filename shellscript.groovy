node{
   
    stage 'Test'
        echo 'test'
    stage 'check out'
        git url:'https://github.com/Shiva243/config.git'
        echo 'Successfully checkout'
    stage 'Build project'
      def sout = new StringBuffer(), serr = new StringBuffer()
      def proc ='./script.sh'.execute()
      proc.consumeProcessOutput(sout, serr)
      proc.waitForOrKill(1000)
      println sout
}




