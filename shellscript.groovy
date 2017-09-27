def sout = new StringBuffer(), serr = new StringBuffer()

def proc =${workspace}+'script.sh'.execute()

proc.consumeProcessOutput(sout, serr)
proc.waitForOrKill(1000)
println sout
