pipeline{
  agent any
  tools {
    maven 'Maven'
  }
  parameters{
    choice(name: 'Build_version', choices: ['1.1.0', '1.2.0','1.3.0'])
    // booleanParam(name: 'executeTests',dafaultValue: true)
  }
  stages{
    stage('Checkout external proj') {
        steps {
            git branch: 'master',
                credentialsId: 'jenkins-user-github',
                url: 'https://github.com/Naveenkumar9393/SpringBoot.git'
            sh "ls -lat"
        }
    }
    stage("build"){
      steps{
        echo 'Building application ...'
      }
    }
    stage("test"){
      steps{
        echo 'Testing application ...'
      }
    }
    stage("deploy"){
      steps{
        echo "Deployed version ${params.Build_version}"
        sh "mvn clean install"
      }
    }
  }
}
