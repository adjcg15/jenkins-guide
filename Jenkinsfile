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
        sh 'mvn -f Jenkins-Guide_To-Do-List/pom.xml clean compile'       
        echo 'Compilación finalizada!!'
      }
    }

    stage('Unit tests') {
      steps {
        sh 'mvn -f Jenkins-Guide_To-Do-List/pom.xml clean test'
        echo 'Pruebas unitarias finalizadas!!'
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
            --reporter-htmlextra-export Jenkins-Guide_To-Do-List/target/integration-tests-report.html
        '''
      }
    }

    stage('Package') {
      steps {       
        sh 'mvn -f Jenkins-Guide_To-Do-List/pom.xml package -DskipTests'       
        echo 'JAR generado correctamente!!'
      }
    }
    

    stage('Create Docker image'){
      steps {
        script {
          dir('Jenkins-Guide_To-Do-List') {
                def dockerImage = docker.build("tristanstgo/todolist-app")
                docker.withRegistry('https://index.docker.io/v1/', 'docker_credential') {
                              dockerImage.push() }
            }          
        }
        echo 'Imagen de Docker creada y publicada en DockerHub'
      }
    }    
    stage('Deploy') {
      steps {
        dir('Jenkins-Guide_To-Do-List'){
          sh 'docker compose up -d' 
          sleep 15
          sh 'docker compose ps'

        }
        echo 'Aplicación desplegada en la dirección localhost:8081'
      }
    }
}

  post {
    always {
      junit '**/target/surefire-reports/*.xml'

      publishHTML(target: [
        reportDir: 'Jenkins-Guide_To-Do-List/target',
        reportFiles: 'integration-tests-report.html',
        reportName: 'Newman Integration Tests Report',
        alwaysLinkToLastBuild: true,
        keepAll: true
      ])
      
      echo 'Finalizando ejecución del pipeline!'
    }
  }
}
