pipeline {
  agent any

  tools {
    maven 'Maven3'
    nodejs 'v24.12.0'
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

    stage('Integration tests') {
      steps {
        sh '''
          set -e

          echo "Starting Spring Boot app..."
          mvn -f Jenkins-Guide_To-Do-List/pom.xml spring-boot:run &
          APP_PID=$!

          trap "echo Stopping Spring Boot...; kill $APP_PID || true" EXIT

          echo "Waiting for app to start..."
          sleep 15

          echo "Running Postman integration tests..."
          newman run Jenkins-Guide_To-Do-List/to_do_app_api_tests.postman_collection.json \
            --disable-unicode \
            --color off \
            -r htmlextra \
            --reporter-html-export Jenkins-Guide_To-Do-List/target/integration-tests-report.html
        '''
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

      publishHTML(target: [
        reportDir: 'Jenkins-Guide_To-Do-List/target',
        reportFiles: 'integration-tests-report.html',
        reportName: 'Newman Integration Tests Report'
      ])
      
      echo 'Finalizando ejecución del pipeline con pruebas!'
    }
  }
}