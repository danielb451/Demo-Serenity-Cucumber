
pipeline {
    agent any

    options {
        skipDefaultCheckout()
    }

    tools {
        maven 'Maven3'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Verificar herramientas') {
            steps {
                bat 'java -version'
                bat 'mvn -version'
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn -B clean verify'
            }
        }

        stage('Report') {
            steps {
                publishHTML(target: [
                    allowMissing: true,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'target/site/serenity',
                    reportFiles: 'index.html',
                    reportName: 'Serenity Report'
                ])
            }
        }
    }
}
