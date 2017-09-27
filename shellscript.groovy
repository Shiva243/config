
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
      
   
}




