def gitDownload(repo)
{
   git "https://github.com/intelliqittrainings/${repo}.git"

}

def mavenBuild()
{
   sh 'mvn package'
}

def tomcatDeploy(jobname,ip,context)
{
    sh "scp /home/ubuntu/.jenkins/workspace/${jobname}/webapp/target/webapp.war ubuntu@${ip}:/var/lib/tomcat9/webapps/${context}.war"
}

def runSelenium(jobname)
{
    sh "java -jar /home/ubuntu/.jenkins/workspace/${jobname}/testing.jar"
}
