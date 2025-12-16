pipeline {
  agent any

  tools {
    maven 'Maven3'
  }

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
        sh 'mvn -f Jenkins-Guide_To-Do-List/pom.xml clean install'       
        echo 'Compilación finalizada!!'
      }
    }

    stage('Unit tests') {
      steps {
        sh 'mvn -f Jenkins-Guide_To-Do-List/pom.xml clean test'
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
      junit '**/target/surefire-reports/*.xml'
      echo 'Finalizando ejecución del pipeline con pruebas!'
    }
  }
}