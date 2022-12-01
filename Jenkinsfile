pipeline{
  agent any
  parameters{
    choice(name: 'VERSION', choices: ['1.1.0', '1.2.0','1.3.0'])
    // booleanParam(name: 'executeTests',dafaultValue: true)
  }
  stages{
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
        echo 'Deploying application ...'
          echo "Deployed version ${params.VERSION}"
        sh "mvn clean install"
      }
    }
  }
}
