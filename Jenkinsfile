pipeline{
  agent any
  tools {
    maven 'Maven'
  }
  parameters{
    choice(name: 'VERSION', choices: ['1.1.0', '1.2.0','1.3.0'])
    // booleanParam(name: 'executeTests',dafaultValue: true)
  }
  stages{
    stage('clone repo'){
          script {
           // The below will clone your repo and will be checked out to master branch by default.
           git credentialsId: 'jenkins-user-github', url: 'https://github.com/Naveenkumar9393/SpringBoot.git'
           // Do a ls -lart to view all the files are cloned. It will be clonned. This is just for you to be sure about it.
           sh "ls -lart ./*" 
           // List all branches in your repo. 
           sh "git branch -a"
           // Checkout to a specific branch in your repo.
           sh "git checkout master"
          }   
    }
    stage("build"){
      steps{
        echo 'building application ...'
      }
    }
    stage("test"){
      steps{
        echo 'Testing application ...'
      }
    }
    stage("deploy"){
      steps{
        echo "Deployed version ${params.VERSION}"
        sh "mvn clean install"
      }
    }
  }
}
