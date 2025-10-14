pipeline {
  agent any

  //tools {}

  //environment {}

  stages {
    stage('Checkout') {
        steps {
            // Clonación manual del repositorio desde GitHub
            git branch: 'checkout-scm-pipeline',
                url: 'https://github.com/adjcg15/jenkins-guide.git',
                credentialsId: 'github-credential'
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





