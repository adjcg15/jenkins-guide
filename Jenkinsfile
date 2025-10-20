pipeline {
  agent any

  tools {
    git 'Git_AutoInst'
  }

  //environment {}

  stages {
    
    stage('Checkout') {
        steps {
            git branch: 'checkout-scm-pipeline', 
            credentialsId: 'github-credential', 
            url: 'https://github.com/adjcg15/jenkins-guide.git'
        }
    }

    stage('Build') {
      steps {
        echo 'Compilando la aplicación...'
      }
    }
    stage('Test') {
      steps {
        echo 'Ejecutando pruebas...'
      }
    }
    stage('Deploy') {
      steps {
        echo 'Desplegando la aplicación...'
      }
    }
  }

  post {
    always {
      echo 'Finalizando ejecución del pipeline con Polling!'
    }
  }
}





