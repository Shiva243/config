
node{
    stage 'Test'
        echo 'test'
    stage 'check out'
        git url:'https://github.com/Shiva243/config.git'
        echo 'Successfully checkout'
         def w = env.WORKSPACE
   echo "workspace directory is ${w}/script.sh"
    File f = new File("${w}/script.sh");
    stage 'Build project'
      def sout = new StringBuffer(), serr = new StringBuffer()
    def proc = f.canExecute()
      proc.consumeProcessOutput( sout, serr )
proc.waitFor()
    if( sout.size() > 0 ) println sout
   if( serr.size() > 0 ) println serr
}




