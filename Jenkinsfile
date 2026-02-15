pipeline {
    agent any

    tools {
        maven 'Maven'  // Jenkins Global Tool name
        jdk 'JDK17'    // Jenkins Global JDK name
    }

    environment {
        ALLURE_RESULTS = "target/allure-results"
        ALLURE_REPORT = "target/allure-report"
    }

    triggers {
        // GitHub webhook trigger for automatic builds
        githubPush()
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', 
                    url: 'https://github.com/Reddy062023/MySeleniumFramework',
                    credentialsId: 'github-token' // Your GitHub PAT in Jenkins
            }
        }

        stage('Clean') {
            steps {
                sh 'mvn clean'
            }
        }

        stage('Build & Test') {
            steps {
                sh 'mvn test'
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
