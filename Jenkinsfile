pipeline {
  agent any

  tools {}

  environment {}

  stages {
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
      echo 'Finalizando ejecución del pipeline...'
    }
  }
}