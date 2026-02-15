pipeline {
    agent any

    tools {
        maven 'Maven'   // Maven installation name in Jenkins
        jdk 'JDK17'     // JDK installation name in Jenkins
    }

    environment {
        ALLURE_RESULTS = "target/allure-results"
        ALLURE_REPORT  = "target/allure-report"
    }

    triggers {
        githubPush()  // This makes Jenkins automatically trigger on GitHub push
    }

    stages {
        stage('Log Check') {
            steps {
                script {
                    echo "Webhook triggered at: ${new Date()}"
                }
            }
        }

        stage('Checkout') {
            steps {
                git branch: 'main', 
                    url: 'https://github.com/Reddy062023/MySeleniumFramework.git',
                    credentialsId: 'github-token' // Your Jenkins PAT credential
            }
        }

        stage('Clean') {
            steps {
                bat 'mvn clean'   // Use 'bat' for Windows
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn test'    // Use 'bat' for Windows
            }
        }

        stage('Allure Report') {
            steps {
                allure includeProperties: false, jdk: '', results: [[path: "${ALLURE_RESULTS}"]]
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: '**/target/*.jar', allowEmptyArchive: true
            junit 'target/surefire-reports/*.xml'
        }
        failure {
            mail to: 'your-email@example.com',
                 subject: "Pipeline Failed: ${currentBuild.fullDisplayName}",
                 body: "Check Jenkins for details: ${env.BUILD_URL}"
        }
    }
}
