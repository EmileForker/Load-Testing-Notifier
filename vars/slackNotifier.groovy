#!/usr/bin/env groovy

def call(String buildResult) {
  if ( buildResult == "SUCCESS" ) {
    slackSend color: "good", message: "Job: ${env.JOB_NAME} performed on Scrum: ${env.SCRUM_NUMBER} with buildnumber ${env.BUILD_NUMBER} was successful. More ${env.BUILD_URL}"
  }
  else if( buildResult == "FAILURE" ) { 
    slackSend color: "danger", message: "Job: ${env.JOB_NAME} performed on Scrum: ${env.SCRUM_NUMBER} with buildnumber ${env.BUILD_NUMBER} was failed. More ${env.BUILD_URL}"
  }
  else if( buildResult == "UNSTABLE" ) { 
    slackSend color: "warning", message: "Job: ${env.JOB_NAME} performed on Scrum: ${env.SCRUM_NUMBER} with buildnumber ${env.BUILD_NUMBER} was unstable. More ${env.BUILD_URL}"
  }
  else {
    slackSend color: "danger", message: "Job: ${env.JOB_NAME} performed on Scrum: ${env.SCRUM_NUMBER} with buildnumber ${env.BUILD_NUMBER} was unclear. More ${env.BUILD_URL}"	
  }
}
