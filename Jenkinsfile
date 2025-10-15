pipeline {
  agent any

  //tools {}

  //environment {}

  stages {
    
    stage('Checkout') {
        steps {
            checkout scm
        }
    }

    stage('Build') {
      steps {
        echo 'Compilando la aplicación...'
        steps {
          withMaven(maven: 'Maven3', traceability: true) {
            sh 'mvn clean install'
          }
        }
        echo 'Compilación finalizada!!'
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





