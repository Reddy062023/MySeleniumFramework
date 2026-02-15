pipeline {
    agent any

    tools {
        maven 'Maven'   // Name of Maven installation in Jenkins Global Tool Configuration
        jdk 'JDK17'     // Name of JDK installation in Jenkins
    }

    environment {
        ALLURE_RESULTS = "target/allure-results"
        ALLURE_REPORT  = "target/allure-report"
        GIT_CREDENTIALS = 'github-token' // Your GitHub Personal Access Token
    }

    stages {

        stage('Checkout SCM') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/Reddy062023/MySeleniumFramework.git',
                    credentialsId: "${GIT_CREDENTIALS}"
            }
        }

        stage('Clean') {
            steps {
                echo 'Cleaning project...'
                bat 'mvn clean'
            }
        }

        stage('Build & Test') {
            steps {
                echo 'Building and running tests...'
                bat 'mvn test'
            }
        }

        stage('Allure Report') {
            steps {
                echo 'Generating Allure report...'
                // Use Jenkins Allure plugin instead of 'allure serve' to avoid browser issues
                allure includeProperties: false, jdk: 'JDK17', results: [[path: "${ALLURE_RESULTS}"]]
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: '**/target/*.jar', allowEmptyArchive: true
            junit 'target/surefire-reports/*.xml'
        }
        success {
            echo 'Build finished successfully!'
        }
        failure {
            echo 'Build failed!'
            // mail step can be uncommented if SMTP is configured
            // mail to: 'your-email@example.com', subject: "Pipeline Failed: ${currentBuild.fullDisplayName}", body: "Check Jenkins for details: ${env.BUILD_URL}"
        }
    }
}
