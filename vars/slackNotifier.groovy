#!/usr/bin/env groovy

def call(String buildResult) {
  if ( buildResult == "SUCCESS" ) {
    slackSend color: "good", message: "Job: ${env.JOB_NAME} performed on Scrum: ${env.SCRUM_NUMBER} with buildnumber <${env.BUILD_URL}|${env.BUILD_NUMBER}> was successful :white_check_mark:"
  }
  else if( buildResult == "FAILURE" ) { 
    slackSend color: "danger", message: "Job: ${env.JOB_NAME} performed on Scrum: ${env.SCRUM_NUMBER} with buildnumber <${env.BUILD_URL}|${env.BUILD_NUMBER}> was failed :crossed_swords:"
  }
  else if( buildResult == "UNSTABLE" ) { 
    slackSend color: "warning", message: "Job: ${env.JOB_NAME} performed on Scrum: ${env.SCRUM_NUMBER} with buildnumber <${env.BUILD_URL}|${env.BUILD_NUMBER}> was unstable :fire:"
  }
  else {
    slackSend color: "danger", message: "Job: ${env.JOB_NAME} performed on Scrum: ${env.SCRUM_NUMBER} with buildnumber <${env.BUILD_URL}|${env.BUILD_NUMBER}> was unclear :fire:"	
  }
}
