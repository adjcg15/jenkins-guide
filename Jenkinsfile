pipeline {
  agent any

  //tools {}

  //environment {}

  stages {
    
    stage('Checkout') {
        steps {
            checkout scm
            echo 'Repositorio clonado correctamente!!'
        }
    }

    stage('Build') {
      steps {       
        withMaven(maven: 'Maven3', traceability: true) {
          sh 'mvn -f Jenkins-Guide_To-Do-List/pom.xml clean install'
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





